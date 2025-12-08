package Controller;

import javax.swing.JTextPane;

public class controller_Information {
    private JTextPane textPane;
    
    public controller_Information(JTextPane pane) {
        this.textPane = pane;
    }

    public void displayMessage(String message){
        textPane.setText(message);
    }
}
