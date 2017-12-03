import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class SimGUI {

    private JPanel panel1;
    private JProgressBar progressBar1;
    private JProgressBar progressBar5;
    private JProgressBar progressBar3;
    private JProgressBar progressBar4;
    private JProgressBar progressBar2;
    private JButton startSimulatorButton;
    private JCheckBox busy1CheckBox;
    private JCheckBox busy2CheckBox;
    private JCheckBox busy3CheckBox;
    private JCheckBox busy4CheckBox;
    private JCheckBox busy5CheckBox;
    private JButton stopButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;


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
