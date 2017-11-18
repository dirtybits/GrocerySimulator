import java.util.ArrayList;
import java.time.Duration;

public class CashierManager {

    private static ArrayList<Duration> _lineTime = new ArrayList<Duration>();
    private static ArrayList<Duration> _checkoutTime = new ArrayList<Duration>();

    public static void times(Duration lineTime, Duration checkoutTime){
        _lineTime.add(lineTime);
        _checkoutTime.add(checkoutTime);
    }

    private ArrayList<Cashier> cashierManager = new ArrayList<Cashier>();
    public void addCustomer(){

    }



}
