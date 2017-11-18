import java.util.Random;

public class SimDriver {
    public boolean keepRunning = true;
    public static void main(String args[]){

        SimDriver sd = new SimDriver();
        CashierManager manager = new CashierManager();

        while (sd.keepRunning){
            Double value = Math.random();
            if (value > 0.75){
                // add a new customer
                Customer c = new Customer();
                manager.addCustomer(c);

            }else{
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    //.sleep can throw and exception
                }

            }
            manager.rearangeLines();
        }
    }

}
