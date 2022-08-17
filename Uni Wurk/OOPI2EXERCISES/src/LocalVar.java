class LocalVar {
    public static int count = 0;
    public static int sum(int[] arr) {
        int c = 0;
        for(int i = 0; i < arr.length; i++) {
            c = c + arr[i];
            count++;
        }
        System.out.println("Count = " + count);
        return c;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(sum(a));
        System.out.println("Count = " + count);
    }

}
