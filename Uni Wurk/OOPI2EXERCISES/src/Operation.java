import java.util.Arrays;

public class Operation {
    public static int doOperation(String op) {
        int eval = 0;
        String[] Op = op.split("");
        for (int i = 0; i < Op.length; i++) {
            if (Op[i].equals("+")) {
                String c = String.join("", Arrays.copyOfRange(Op, 0, i));
                int a = Integer.parseInt(c);

                String d = String.join("", Arrays.copyOfRange(Op, i + 1, Op.length));
                int b = Integer.parseInt(d);
                eval =  a + b;
                break;
            }
            if (Op[i].equals("-")) {
                String c = String.join("", Arrays.copyOfRange(Op, 0, i));
                int a = Integer.parseInt(c);

                String d = String.join("", Arrays.copyOfRange(Op, i + 1, Op.length));
                int b = Integer.parseInt(d);
                eval = a - b;
                break;
            }
            if (Op[i].equals("*")) {
                String c = String.join("", Arrays.copyOfRange(Op, 0, i));
                int a = Integer.parseInt(c);

                String d = String.join("", Arrays.copyOfRange(Op, i + 1, Op.length));
                int b = Integer.parseInt(d);
                if (a == 0 || b == 0) {
                    eval = 0;
                    break;
                }
                 eval = a * b;
                 break;
            }
            if (Op[i].equals("/")) {
                String c = String.join("", Arrays.copyOfRange(Op, 0, i));
                int a = Integer.parseInt(c);

                String d = String.join("", Arrays.copyOfRange(Op, i + 1, Op.length));
                int b = Integer.parseInt(d);
                if (a == 0 || b == 0) {
                    eval = -1;
                    break;
                }
                eval =  a / b;
                break;
            }
        }
        return eval;
    }

    public static int foo(int n) {
        if (n < 3) return 1;
        return (foo(n - 3) - 2) * (foo(n - 2) + 3) * (foo(n -3));

    }
    public static void main(String[] args) {
        System.out.println(foo(3));
    }
}
