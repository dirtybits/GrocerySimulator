import java.time.Duration;

public class SimDriver {
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
