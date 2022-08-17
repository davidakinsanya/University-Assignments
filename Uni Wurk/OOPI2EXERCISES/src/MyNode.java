public class MyNode<T> {
    T payload;
    MyNode<T> next;
    MyNode<T> prev;

    public MyNode(T payload) {
        this.payload = payload;
        this.next = null;
        this.prev = null;
    }
    public MyNode(T payload, MyNode<T> next, MyNode<T> prev) {
        this.payload = payload;
        this.next = next;
        this.prev = prev;
    }
}
