import java.io.*;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;

public class StringNode {
    StringNode next;
    String payload;

    public StringNode(String payload) {
        this.payload = payload;
        next = null;
    }

    public StringNode(String payload, StringNode next) {
        this.payload = payload;
        this.next = next;
    }
}
