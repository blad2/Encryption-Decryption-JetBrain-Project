class Problem {
    public static void main(String[] args) {
        String output = "";
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0 && "mode".equals(args[i])) {
                output = args[i + 1];
                break;
            }
            output = "default";
        }
        System.out.println(output);
    }
}