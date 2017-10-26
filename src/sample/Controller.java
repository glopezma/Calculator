package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label result;
    private long number1 = 0;
    private String operator = "";
    private boolean start = true;
    private Model model = new Model();

    public void processNumbers(ActionEvent e) {
        if (start) {
            result.setText("");
            start = false;
        }
        String value = ((Button)e.getSource()).getText(); //grabs the text from the buttons so don't need switch statement
        result.setText(result.getText() + value);
    }

    public void processOperators(ActionEvent e) {
        String value = ((Button)e.getSource()).getText();

        if (!value.equals("=")) {
            if (!operator.isEmpty()) {
                return;
            } else {
                operator = value;
                number1 = Long.parseLong(result.getText());
                result.setText("");
            }
        } else {
            if (operator.isEmpty()) {
                return;
            } else {
                long number2 = Long.parseLong(result.getText());
               float output =  model.calculate(number1, number2, operator);
               result.setText(String.valueOf(output));
               operator = "";
               start = true;
            }
        }
    }
}
