class ThreeX {
    public static void main(String[] args) {
        {
            int x = 0;
            System.out.println("1. x = " + x);
        }
        System.out.print("2. x = ");
        for(int x = 0; x <= 5; x++) {
            System.out.print(x);
        }
        System.out.println();
        int x;
        if ((x = 5) < 10) {
            System.out.println("3. 10 is bigger than " + x);
        }
    }
}
