class Node {
    private String value;
    private Node next;

    public Node(String value) {
        this.value = value;
        this.next = null;
    }
    
    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public boolean isEmpty() { return next == null; }

    public void addHead(String value) {
        if (isEmpty()) {
            next = new Node(value);
        } else {
            next.addHead(value);
        }
    }

    public void removeHead() {
        if (isEmpty()) {
            next = next.getNext();
        } else {
            next.removeHead();
        }
    }

    public void insertNode(String value, Node n){ Node p = new Node(value, n.getNext()); }

    public void printList() {
        for (Node cur = this; cur != null; cur = cur.getNext()) {
            System.out.println(cur.getValue());
        }
    }

    public String getValue() {
        return this.value;
    }

    public Node getNext() {
        return this.next;
    }
}  
    
