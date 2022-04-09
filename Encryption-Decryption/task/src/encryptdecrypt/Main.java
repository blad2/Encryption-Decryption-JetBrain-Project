package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        //String[] args1 = {"java", "Main", "-mode", "dec", "-key", "5", "-data", "Bjqhtrj yt mdujwxpnqq!", "-alg", "shift"};
        ClassArgument data = new ClassArgument(args);
        if (!data.isFiling()) {
            if (data.isEncrypting()) {
                System.out.println(data.getEncryptedValue());
            } else {
                System.out.println(data.getDecryptedValue());
            }
        }
    }
}
