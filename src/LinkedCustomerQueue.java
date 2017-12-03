

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

        }else{

            rear.setNextNode(new GenericNode<Customer>(customer,null));
            rear = rear.getNextNode();
        }
        count++;

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

    public Customer removeLast()
    {
        GenericNode<Customer> cursor = front;
        if(!isEmpty())
        {
            Customer customer = rear.getData();
            while(true) {
                try{
                    if (cursor.getNextNode().getData() == customer)
                    {
                        rear = cursor;
                        cursor.removeNodeAfter();
                        // dont forget to decrement the count variable
                        count--;
                        return customer;
                    }
                    else{
                        cursor = cursor.getNextNode();
                    }

                }catch(java.lang.NullPointerException ex){
                    return null;
                }
            }

        }

        return null;
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

   /* public static void main(String[] args) {
        LinkedCustomerQueue queue = new LinkedCustomerQueue();

        queue.add(new Customer());
        queue.add(new Customer());
        System.out.println(queue.toString());

        Customer removedCus = queue.remove();

        System.out.println(queue.toString());

    }
*/

}
//d