import java.io.*;

class TreeNode {
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public TreeNode(String value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() { return this.left; }
    public TreeNode getRight() { return this.right; }
    public String getValue() { return this.value; }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public void writePreOrder(BufferedWriter b) throws IOException {
        b.write(this.value);
        b.newLine();
        if (this.left != null) this.left.writePreOrder(b);
        if (this.right != null) this.right.writePreOrder(b);
    }
}