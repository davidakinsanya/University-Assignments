public class StringStack {
    String[] arr;
    int top;
    int full;

    public StringStack(int size) {
        arr = new String[size];
        top = 0;
        full = size;
    }

    public boolean isEmpty() { return top == 0; }
    public boolean isFull() {return top == full; }

    public void push(String s) {
        if (!isFull()) {
            arr[top] = s;
            top++;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            top--;
            arr[top] = null;
        }
    }

    public void print() {
        for (String s: arr) {
            System.out.println(s);
        }
    }
}
