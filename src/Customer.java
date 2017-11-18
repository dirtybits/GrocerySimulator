public class Customer {

    private double arrivalTime;
    private double serviceTime;
    private double waitTime;

    public Customer(double ar){
        this.arrivalTime = ar;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Customer [arrivalTime=" + arrivalTime + "]";
    }

    public double getServiceTime() {
        return serviceTime;
    }


    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    public void setWaitTime(double waitTime) {
        // TODO Auto-generated method stub
        this.waitTime = waitTime;

    }
    public double getWaitTime(){
        return waitTime;
    }

}
