import java.util.ArrayList;
import java.time.Duration;

public class CashierManager {

    private ArrayList<Duration> _lineTime = new ArrayList<Duration>();
    private ArrayList<Duration> _checkoutTime = new ArrayList<Duration>();

    public void times(Duration lineTime, Duration checkoutTime){
        _lineTime.add(lineTime);
        _checkoutTime.add(checkoutTime);
    }

    private ArrayList<Cashier> cashierManager = new ArrayList<Cashier>();




}
