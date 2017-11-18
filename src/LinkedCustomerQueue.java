

public class LinkedCustomerQueue {

    private GenericNode<Customer> front;
    private GenericNode<Customer> rear;
    private int count;

    public LinkedCustomerQueue(){
        this.count = count;
    }

    public void add(Customer customer){

        if(front == null){

            front = new GenericNode<Customer>(customer, front);
            rear = front;
            count++;

        }else{

            rear.setNextNode(new GenericNode<Customer>(customer,null));
            rear = rear.getNextNode();
            count++;
        }
    }
    public Customer remove(){

        Customer customer = null;

        if(!isEmpty()){
            customer = front.getData();
            front = front.getNextNode();
            count--;

            if(front == null){
                rear = null;
            }
        }
        return customer;

    }
    public boolean isEmpty(){
        return count == 0;
    }


    @Override
    public String toString() {
        String info = "";
        GenericNode<Customer> cursor;
        for(cursor = front; cursor != null; cursor = cursor.getNextNode()){
            info += cursor.getData() + "\n";
        }
        return info;
    }
    public int size(){
        return count;
    }

    public static void main(String[] args) {
        LinkedCustomerQueue queue = new LinkedCustomerQueue();

        queue.add(new Customer());
        queue.add(new Customer());
        System.out.println(queue.toString());

        Customer removedCus = queue.remove();

        System.out.println(queue.toString());

    }


}
