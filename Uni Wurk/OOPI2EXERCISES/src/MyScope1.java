class MyScope1 {
    public static void main(String[] args) {
        {
            int x = 1;
        }
        int x = 42;
        System.out.println(x);
    }
}
