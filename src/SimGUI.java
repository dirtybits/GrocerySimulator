import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class SimGUI {

    private JPanel panel1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar2;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JProgressBar progressBar5;
    private JButton startSimulatorButton;
    private JTextArea textArea1;

    // this is

    public SimGUI() {
        startSimulatorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   SimDriver.main(new String[0]);
               } catch (Exception ex){
                   ex.printStackTrace();
               }
            }
        });
    }
}
