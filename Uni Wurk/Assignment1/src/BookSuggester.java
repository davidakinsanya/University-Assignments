import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BookSuggester {

    static boolean isLeftOrRight(String s, TreeNode r) {
        return (s.equals(r.getValue()));
    }

    static boolean askYesNo(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        String input = scanner.nextLine();
        return input.equals("y");
    }

    static ArrayList<String> readPreOrder(BufferedReader b, ArrayList<String> s) throws IOException {
        String payload;
        while ((payload = b.readLine()) != null) {
            s.add(payload);
        }
        return s;
    }

    static TreeNode createNodes(ArrayList<String> a) {
        TreeNode t = new TreeNode(a.get(0));
        a.remove(a.get(0));
        if (t.getValue().contains("[y/n]")) t.left = createNodes(a);
        if (t.getValue().contains("[y/n]")) t.right = createNodes(a);
        return t;
    }

    static void gameDialogue(TreeNode r, TreeNode[] arr) {
        if (r.isLeaf()) {
            System.out.println("Perhaps you would like " + r.getValue());
            arr[0] = r;
            return;
        }
        if (askYesNo(r.getValue())) {
            gameDialogue(r.getLeft(), arr);
        } else {
            gameDialogue(r.getRight(), arr);
        }
    }

    static void saveGame(TreeNode r, File file) throws IOException {
        if (!askYesNo("Do you want to play again? [y/n]")) {
            if (askYesNo("Would you like to save the current tree? [y/n]")) {
                System.out.println("Enjoy your book.");
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                r.writePreOrder(writer);
                writer.close();
                System.exit(0);
            } else System.exit(0);
        }
    }

    static TreeNode suggestionDialogue(TreeNode r, TreeNode t, File file) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you prefer instead? ");
        String input = scanner.nextLine();
        System.out.println("Tell me a question that distinguishes " + input + " and " + t.getValue());
        String input2 = scanner.nextLine();
        TreeNode tCopy = t;
        t = new TreeNode(input2 + " [y/n]", new TreeNode(input), tCopy);

        if (isLeftOrRight(tCopy.getValue(), r.getLeft().getLeft())) r.left.left = t;
        else if (isLeftOrRight(tCopy.getValue(), r.getLeft().getRight())) r.left.right = t;
        else r.right = t;

        saveGame(r, file);
        return t;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\david\\Assignment1\\src\\suggestions.txt");

        int rounds = 1;
        TreeNode[] arr = new TreeNode[1];
        ArrayList<String> txtNodes = new ArrayList<>();
        TreeNode Leaf2 = new TreeNode("The NoteBook");
        TreeNode Leaf3 = new TreeNode("Pride And Prejudice");
        TreeNode Leaf = new TreeNode("Treasure Island");
        TreeNode Root2 = new TreeNode("Are you in the mood for something Modern? [y/n]", Leaf2, Leaf3);
        TreeNode Root = new TreeNode("Do you like Romance? [y/n]", Root2, Leaf);
        System.out.println("Welcome to Book Suggester");

        while (true) {
            if (rounds > 1) arr[0] = suggestionDialogue(Root, arr[0], file);
            if (file.length() != 0) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                ArrayList<String> readToArray = readPreOrder(reader, txtNodes);
                reader.close();
                TreeNode newNodes = createNodes(readToArray);
                gameDialogue(newNodes, arr);
            } else gameDialogue(Root, arr);
            if (askYesNo("Is this satisfactory? [y/n]")) saveGame(Root, file); else rounds++;
        }
    }
}