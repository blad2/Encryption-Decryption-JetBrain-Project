
class Problem {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            if (i % 2 == 0) {
                output.append(args[i]).append("=").append(args[i + 1]).append("\n");
            }
        }
        System.out.println(output);
    }
}