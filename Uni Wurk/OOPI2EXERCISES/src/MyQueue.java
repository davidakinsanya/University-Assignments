public class MyQueue<T> {
    private T payload;
    private MyNode<T> back;
    private MyNode<T> front;

    public MyQueue() {
        this.back = null;
        this.front = null;
    }

    public boolean isEmpty() {
        return back == null;
    }

    public int size() {
        int count = 0;
        while (front != null) {
            count++;
            front = front.prev;
        }
        return count;
    }

    public void enqueue(T payload) {
        MyNode<T> n = new MyNode<T>(payload);
        if (isEmpty()) { // If the queue is empty
            this.front = n; // the new node also becomes the new front
        } else { // If the queue wasn't empty
            n.next = back; // make new node link to old back
            back.prev = n; // tell the old back what's behind it
        }
        back = n; // New node is now at the back
    }

    public T dequeue() {
        T s = front.payload; // Read the payload from front
        front = front.prev; // Second node is now at front
        if (front == null) { // If this was the only element, the list is empty now
            back = null; // and the back node also has to be cleared
        } else { // If the list isn't empty now
            front.next = null; // delete reference to old front from predecessor
        }
        return s;
    }

    public void remove(T payload) {
        while (front != null) {
            if (front.payload == payload) {
                System.out.println("gottemm" + " " + payload);
                return;
            }
            front = front.prev;
        }
    }

    public void insertAt(int i, T payload) {
        MyNode<T> n = new MyNode<T>(payload);
        int count = 0;
         while (front != null) {
             count++;
             if (count == i) {
                 // append the node..
                 return;
             }
             front = front.prev;
         }
    }

    public void print() {
        while (front != null) {
            System.out.println(front.payload);
            front = front.prev;
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> num = new MyQueue<Integer>();
        num.enqueue(42);
        num.enqueue(3);
        num.enqueue(67);
        //num.remove(67);
        num.print();
    }
}
