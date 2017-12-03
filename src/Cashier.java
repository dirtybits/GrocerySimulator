import java.time.*;
public class Cashier extends Thread{

    private boolean _isBusy = false;
    private int _customerServed = 0;
    private boolean _stop = false;
    public LinkedCustomerQueue line;
    private boolean _isServing = false;

    private Customer _currentCustomer = null;
    private int _timeSpentServing = 0;
    private long _currentCustomerStartServingTime;
    private long _currentCustomerEndServingTime;

    private int _sleepInterval = 0;

    private static CashierManager myManager = null;

    Cashier(int cashierSleepInterval, CashierManager manager){
        line = new LinkedCustomerQueue();
        _sleepInterval = cashierSleepInterval;


        myManager = manager;

    }

    // returns true if the cashier is not serving anyone and the customer queue is empty
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

    // the infinite loop of the cashier class
    private void runner() {
        while (_stop != true) {
            // do cashier stuff here
            if (_currentCustomer == null){
                // try to get the next customer
                if (line.size() != 0){
                    _currentCustomer = line.remove();
                    _currentCustomer.startedServing();

                    _currentCustomerStartServingTime = System.nanoTime();

                    _timeSpentServing = 0;
                    _isServing = true;

                    // ask the manager to rearrange lines considering that this one is now shorter
                    myManager.rearrangeLines();
                }
            }else{

                if (_timeSpentServing == _currentCustomer.getCheckoutTime()){
                    //checkout is done
                    _currentCustomerEndServingTime = System.nanoTime();
                    _customerServed++;

                    // update times in the manager class
                    long lineTime = _currentCustomer.getLineTime();

                    long checkoutTime =  _currentCustomerEndServingTime - _currentCustomerStartServingTime;
                    CashierManager.times(lineTime, checkoutTime);



                    // remove the customer from the line
                    // grab the next customer at the next iteration
                    _currentCustomer = null;
                    _isServing = false;

                    System.out.println("Checkout Finished");
                }else{
                    // add 1 to the process time
                    _timeSpentServing += 1;
                }
            }
            try {
                this.currentThread().sleep(_sleepInterval);

            } catch (InterruptedException e) {
                //.sleep can throw and exception
            }
        }
    }


    // stops and terminates the cashier
    // If the thread tries to kill itself but is already dead an exception can be thrown
    public void kill() throws Exception {
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

    public int getServedCustomers(){
        return _customerServed;
    }

    public int getPercentageDone(){

        //todo

        return 0;
    }
}
