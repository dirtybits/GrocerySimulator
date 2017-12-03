import javax.swing.*;
import java.awt.event.*;

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

        busy1CheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        busy2CheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        busy3CheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        busy4CheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        busy5CheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
    }
    public boolean keepRunning = true;
    public static final int _CASHIERSLEEPINTERVAL = 100;
    public static final double LIKLYHOODOFACUSTOMER = 0.75;

    public static void main(String args[]){
        CashierManager manager = new CashierManager(_CASHIERSLEEPINTERVAL);
        //test code
        for (int i = 100; i>= -0; i--){
            Double value = Math.random();
            if (value > LIKLYHOODOFACUSTOMER){
                // add a new customer
                Customer c = new Customer();
                manager.addCustomer(c);
            }else{
                try {
                    Thread.sleep(_CASHIERSLEEPINTERVAL);
                } catch (InterruptedException e) {
                    //.sleep can throw and exception
                }

            }
            manager.rearrangeLines();
        }
        while(!manager.cashiersDone()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                //.sleep can throw and exception
            }
        }

        System.out.println("Stats:");

        long durStats[] = manager.getStats();
        System.out.println(durStats[0]);
        System.out.println(durStats[1]);
        System.out.println(durStats[2]);
        System.out.println(durStats[3]);

    }
}
