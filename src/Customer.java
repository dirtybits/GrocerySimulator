import java.time.Duration;
import java.time.Instant;

import java.util.Random;

public class Customer {

    private int _itemCount = 0;
    private int _timingMultiplier = 2;
    private Instant _lineStartTime = null;
    private Instant _lineEndTime = null;
    public Duration checkoutTime = null;

    public Customer(){
        // preliminary numbers
        _itemCount = getRandomInteger(50, 1);
        _lineStartTime = Instant.now();

    }

    //@Override
    //public String toString() {
        //return "Customer [arrivalTime=" + arrivalTime + "]";
    //}

    public Instant getArrivalTime() {
        return _lineStartTime;
    }
    //returns the time spent in line
    public Duration getLineTime() {
        return Duration.between(_lineStartTime, _lineEndTime);
    }

    public void startedServing(){
        _lineEndTime = Instant.now();
    }

    public int getCheckoutTime() {
        return _itemCount * _timingMultiplier;
    }

    private int getRandomInteger(int upperBound, int lowerBound) {
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());

        int randomNum = rand.nextInt((upperBound - lowerBound) + 1) + lowerBound;
        return randomNum;
    }
}