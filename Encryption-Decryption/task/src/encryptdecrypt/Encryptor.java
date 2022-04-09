package encryptdecrypt;

public class Encryptor {
    private String decryptedString;
    private String encryptedText;

    Encryptor(String decryptedString) {
        this.decryptedString = decryptedString;
    }

    //Replace each latter with the letter in the corresponding position. This method to use in the first stage of the project
    public String encryptReverse() {
        String[] decryptedLetters = decryptedString.split("");
        StringBuilder outputText = new StringBuilder();
        for (int i = 0; i < decryptedString.length(); i++) {
            String stringToEncrypt = decryptedLetters[i];
            if (stringToEncrypt.equals("!") || stringToEncrypt.matches("\\s")){ // Checking the space first to avoid arrayOutOfBoundException when adding the letter index
                outputText.append(decryptedLetters[i]);
                continue;
            }
            //int letterStringIndex = decryptedLetters[i].charAt(0) - 97; // this variable is to access the char location in the local variable
            char encryptedLetter = (char) (122 % stringToEncrypt.charAt(0) + 97);
            outputText.append(encryptedLetter);

        }
        return outputText.toString();
    }

    // stage 2 of the project ""LowerCase letter a-z""
    public String encryptCharLimited(int key) {
        String[] decryptedLetters = decryptedString.split("");
        StringBuilder outputText = new StringBuilder();
        for (int i = 0; i < decryptedString.length(); i++) {
            char charToEncrypt = decryptedLetters[i].charAt(0);
            if (decryptedLetters[i].equals(" ")){ // Checking the space first to avoid arrayOutOfBoundException when adding the letter index
                outputText.append(decryptedLetters[i]);
                continue;
            }
            if (decryptedLetters[i].equals("!")) {
                outputText.append(decryptedLetters[i]);
                continue;
            }
            if (decryptedLetters[i].matches("\\d")) { // match any digit
                outputText.append(decryptedLetters[i]);
                continue;
            }
            char encryptedLetter;
            if (Character.toUpperCase(charToEncrypt) == charToEncrypt) {
                encryptedLetter = ((charToEncrypt + key) > 90) ? (char) (((charToEncrypt + key) % 90) + 64) : (char) ((charToEncrypt + key) % 90);
            } else {
                encryptedLetter = ((charToEncrypt + key) > 122) ? (char) (((charToEncrypt + key) % 122) + 96) : (char) ((charToEncrypt + key) % 122);
            }
            outputText.append(encryptedLetter);
        }
        return outputText.toString();
    }

    // stage 3 of the project changing all characters.
    public String encrypt(int key) {
        String[] decryptedLetters = decryptedString.split("");
        StringBuilder outputText = new StringBuilder();
        for (int i = 0; i < decryptedString.length(); i++) {
            char charToEncrypt = decryptedLetters[i].charAt(0);
            outputText.append((char) (charToEncrypt + key));
        }
        setEncryptedText(outputText.toString());
        return outputText.toString();
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }

    public String getEncryptedText() {
        return encryptedText;
    }
}
