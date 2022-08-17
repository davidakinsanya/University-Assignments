class InstanceScope {
    public String x;
    private int v;
    public InstanceScope (String x) {
        this.x = x;
        v = 0;
    }

    private void doSomething (float f) {
        // scope of z starts here
        float z = f;
        for (int x = 1; x<3; x++) {
            // scope of a,x starts here
            int a = x;
        }
        // scope of a,x ends here
        // scope of w starts here
        int w = 4;
        // scope of w,z ends here
    }
}

