public class StringQueue {
    String[] arr;
    int front, back;

    public StringQueue(int size) {
        arr = new String[size];
        front = 0;
        back = 0;
    }

    public void enqueue(String s) {
        arr[back] = s;
        back++;
        if (back == arr.length) back = 0;
    }

    public String dequeue() {
        String s = arr[front];
        //arr[front] = null;
        front++;
        if (front == arr.length) front = 0;
        return s;
    }

    public void print() {
        for (String s: arr) {
            System.out.println(s);
        }
    }
}
