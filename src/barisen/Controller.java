package barisen;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

import java.util.Random;

public class Controller {

    @FXML
    TextField lengthField;

    @FXML
    TextField getPwField;

    @FXML
    public void generatePassword(){
        getPwField.setEditable(false);
        try{
            Integer length = Integer.valueOf(lengthField.getText());
            String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String chars = "abcdefghijklmnopqrstuvwxyz";
            String nums = "0123456789";
            String symbols = "!@#$%^&*_=+-/€.?<>)";

            String passSymbols = charsCaps+chars+nums+symbols;
            Random rand = new Random();

            char[] pwChars = new char[length];
            for (int i=0; i<length; i++) {
                pwChars[i] = passSymbols.charAt(rand.nextInt(passSymbols.length()));
            }
            String password = new String(pwChars);
            getPwField.setText(password);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Enter valid length!");
            alert.showAndWait();
        }
    }

    @FXML
    public void copyPw(){
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(getPwField.getText());
        clipboard.setContent(content);
    }

}
