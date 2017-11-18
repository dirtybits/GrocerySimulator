import java.util.ArrayList;
import java.time.Duration;

public class CashierManager {
    private int _cashierCount = 5;
    private static ArrayList<Duration> _lineTime = new ArrayList<>();
    private static ArrayList<Duration> _checkoutTime = new ArrayList<>();

    private ArrayList<Cashier> cashiers = new ArrayList<>();

    CashierManager(){

        for (int i = 0; i < _cashierCount; i++){
            Cashier c = new Cashier();
            cashiers.add(c);
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
        shortestLine.addCustomerToLine(c);
    }

    public void rearangeLines() {
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
}