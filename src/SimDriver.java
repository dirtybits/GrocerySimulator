import java.time.Duration;

public class SimDriver {
    public boolean keepRunning = true;
    public static void main(String args[]){

        SimDriver sd = new SimDriver();
        CashierManager manager = new CashierManager();



        // the real one
//        while (sd.keepRunning){
//            Double value = Math.random();
//            if (value > 0.75){
//                // add a new customer
//                Customer c = new Customer();
//                manager.addCustomer(c);
//
//            }else{
//                try {
//                    Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    //.sleep can throw and exception
//                }
//
//            }
//            manager.rearrangeLines();
//        }

          //test code
         for (int i = 100; i>= -0; i--){
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
              manager.rearrangeLines();
         }
        try {
             System.out.println("Waiting for cashiers to finish ish.");
             Thread.sleep(30000);
        } catch (InterruptedException e) {
            //.sleep can throw and exception
        }

        Duration durStats[] = manager.getStats();
        System.out.println(durStats[0].toString());
        System.out.println(durStats[1].toString());
        System.out.println(durStats[2].toString());
    }

}
