import java.time.*;
public class Cashier extends Thread{

    private boolean _isBusy = false;
    private int _customerServed = 0;
    private boolean _stop = false;
    public LinkedCustomerQueue line;
    private boolean _isServing = false;

    private Customer _currentCustomer = null;
    private int _timeSpentServing = 0;
    private Instant _currentCustomerStartServingTime;
    private Instant _currentCustomerEndServingTime;


    Cashier(){
        line = new LinkedCustomerQueue();
    }

    // returnes true if the cashier is not serving anyone and the customer queue is empty
    public boolean isNotBusy(){
        if (line.size() == 0 && _isServing ==false){
            return true;
        }else{
            return false;
        }
    }

    // the method that gets called when thread.start is called
    public void run(){
        runner();
    }

    // the infinate loop of the cashier class
    private void runner() {
        while (_stop != true) {
            // do cashier stuff here
            if (_currentCustomer == null){
                // try to get the next customer
                if (line.size() != 0){
                    _currentCustomer = line.remove();
                    _currentCustomer.startedServing();

                    _currentCustomerStartServingTime = Instant.now();

                    _timeSpentServing = 0;
                }
            }else{

                if (_timeSpentServing == _currentCustomer.getCheckoutTime()){
                    //checkout is done
                    _currentCustomerEndServingTime = Instant.now();


                    // update times in the manager class
                    Duration lineTime = _currentCustomer.getLineTime();
                    Duration checkoutTime = Duration.between(_currentCustomerStartServingTime, _currentCustomerEndServingTime);
                    CashierManager.times(lineTime, checkoutTime);

                }else{
                    // add 1 to the process time
                    _timeSpentServing += 1;
                }
            }
            try {
                this.currentThread().sleep(1000

                );
            } catch (InterruptedException e) {
                //.sleep can throw and exception
            }
        }
    }


    // stops and terminates the cashier
    public void kill() {
        _stop = true;
    }

    // adds a customer to the end of the line
    public void addCustomerToLine(Customer c){
        line.add(c);
    }

    // return the customer at the end of the line
    public Customer getCustomerFromEndOfLine(){
        return line.removeLast();
    }
}
