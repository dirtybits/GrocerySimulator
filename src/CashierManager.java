import java.util.ArrayList;
import java.time.Duration;

public class CashierManager {

    private static ArrayList<Duration> _lineTime = new ArrayList<Duration>();
    private static ArrayList<Duration> _checkoutTime = new ArrayList<Duration>();

    public static void times(Duration lineTime, Duration checkoutTime){
        _lineTime.add(lineTime);
        _checkoutTime.add(checkoutTime);
    }
    //
    //
    private ArrayList<Cashier> cashierManager = new ArrayList<Cashier>();

    public CashierManager () {

    }

    public void start(double time) {

        for (int currentTime = 0; currentTime < time; currentTime++) {

            if (isWaiting()) {
                Customer customer = new Customer(currentTime);
                waitLine.add(customer);
            }

            if (!waitLine.isEmpty() && cashierNotBusy()) {
                serviceTime = getServiceTime();
                Customer currentCustomer = waitLine.remove();
                currentCustomer.setServiceTime(serviceTime);
                double waitTime = currentTime - currentCustomer.getArrivalTime();
                currentCustomer.setWaitTime(waitTime);
                customers.add(currentCustomer);
            }

            serviceTime--;

        }

    }

    public boolean cashierNotBusy() {

    }

    public int getServiceTime() {

    }

    public boolean isWaiting() {

    }

    private double averageWaitTime() {

    }

    private double averageServiceTime() {

    }


    @Override
    public String toString() {
        String report = "Average Wait Time: " + averageWaitTime();
        report += "\nRemaining customers: " + waitLine.size();
        report += "\nCustomers Served: " + customers.size();
        report += "\nAverage Service Time: " + averageServiceTime() + "\n";

        for (Customer customer : customers) {
            report += customer.toString() + "\n";
        }

        return report;
    }




}
