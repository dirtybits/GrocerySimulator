import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;

public class CashierManager {
    private int _cashierCount = 5;
    private static ArrayList<Duration> _lineTime = new ArrayList<>();
    private static ArrayList<Duration> _checkoutTime = new ArrayList<>();

    private ArrayList<Cashier> cashiers = new ArrayList<>();

    CashierManager(int cashierSleepInterval){
        for (int i = 0; i < _cashierCount; i++){
            Cashier c = new Cashier(cashierSleepInterval);
            cashiers.add(c);
            c.start();
        }
    }

    public static void times(Duration lineTime, Duration checkoutTime){
        _lineTime.add(lineTime);
        _checkoutTime.add(checkoutTime);
    }

    public void addCustomer(Customer c){
        int shortestLineLength = Integer.MAX_VALUE;
        Cashier shortestLine = null;

        for(Cashier cash: cashiers){
            if (cash.line.size() < shortestLineLength){
                shortestLineLength = cash.line.size();
                shortestLine = cash;
            }
        }

        //for debugging {
        for (int i = cashiers.size() - 1; i >= 0; i--){
            System.out.println("Cashier " + i + " has " + cashiers.get(i).line.size() + " customers");
        }
        // }

        shortestLine.addCustomerToLine(c);
    }

    public void rearrangeLines() {
        while (shouldBeRearranged()) {

            int longestLine = 0;
            Cashier longestLineCash = null;

            int shortestLine = Integer.MAX_VALUE;
            Cashier shortestLineCash = null;


            for(Cashier cash: cashiers){
                if (cash.line.size() > longestLine){
                    longestLine = cash.line.size();
                    longestLineCash = cash;
                }else if(cash.line.size() < shortestLine){
                    shortestLine = cash.line.size();
                    shortestLineCash = cash;
                }
            }
            shortestLineCash.addCustomerToLine(longestLineCash.getCustomerFromEndOfLine());
        }
    }

    private boolean shouldBeRearranged(){
        int longestLine = 0;
        int shortestLine = Integer.MAX_VALUE;

        for(Cashier cash: cashiers){
            if (cash.line.size() > longestLine){
                longestLine = cash.line.size();
            }else if(cash.line.size() < shortestLine){
                shortestLine = cash.line.size();
            }
        }

        if ((longestLine - shortestLine) > 1){
            return true;
        }
        return false;
    }
    // returns the stats of the cashiers as of the current time
    public Duration[] getStats(){

        Duration averageLineTime = Duration.ZERO;
        Duration averageCheckoutTime = Duration.ZERO;
        Duration averageTotalTime = Duration.ZERO;

        int size = _lineTime.size();

        //populate the average variables
        for (int i = size - 1; i>= 1; i--){
            averageLineTime.plus(_lineTime.get(i));
            averageCheckoutTime.plus(_checkoutTime.get(i));


        }
        //divide by the number of indecies

        averageLineTime.dividedBy(size);
        averageCheckoutTime.dividedBy(size);

        averageTotalTime.plus(averageLineTime);
        averageTotalTime.plus(averageCheckoutTime);



        Duration retVal[] = new Duration[3];
        retVal[0] = averageLineTime;
        retVal[1] = averageCheckoutTime;
        retVal[2] = averageTotalTime;

        return retVal;
    }

    //returns true if all cashiers have finished
    public boolean cashiersDone(){
        boolean flag = true;

        for (int i = cashiers.size() - 1; i >= 0; i--){
            if(cashiers.get(i).isNotBusy() == false){
                flag = false;
            }
        }

        return flag;
    }


    // returns true is the cashier threads were all successfully destroyed.
    public boolean endSimulation(){
        try {
            for (int i = cashiers.size() - 1; i >= 0; i--) {
                cashiers.get(i).kill();
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}