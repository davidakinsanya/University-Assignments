public class TestNode {

    static void printNode(Node n) {
        if (n.getNext() == null) {
            System.out.println(n.getValue());
        } else {
            System.out.println(n.getValue());
            printNode(n.getNext());
        }
    }

    static int size(Node n) {
        int count = 0;
        for (Node cur = n; cur != null; cur = cur.getNext()){
            count++;
        }
        System.out.print("The length of a linked list is: ");
        return count;
    }

    static boolean find (String s, Node n) {
        for (Node cur = n; cur != null; cur = cur.getNext()) {
            if (cur.getValue().equals(s)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node first = new Node("Hello", null);
        Node second = new Node("World", first);
        Node third = new Node("!", second);

        //third.removeHead();
        first.addHead("First");
        third.insertNode("New node b", third);
        printNode(third);
    }
}
