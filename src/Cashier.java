public class Cashier extends Thread{

    private boolean _isBusy;
    private int _customerServed;
    private boolean _stop;

    Cashier(){
        _isBuist = false;
        _customerServed = 0;
        _stop = false;
    }

    public void isReady(){

    }

    public void run(){
        System.out.println(Thread.currentThread().getName() + " Started");
        runner();
    }
    public void kill() {
        stop = true;
    }

    private void runner() {
        while (stop != true) {
            // do cashier stuff here

            try {
                this.currentThread().sleep(100

                );
            } catch (InterruptedException e) {
                //.sleep can throw and exception
            }
        }
    }
}
