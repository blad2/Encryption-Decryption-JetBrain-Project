package encryptdecrypt;

public class Decryptor {
    private String encryptedString;
    private String decryptedText;

    Decryptor(String encryptedString) {
        this.encryptedString = encryptedString;
    }

    public String decryptCharLimited(int key) {
        String[] encryptedLetters = encryptedString.split("");
        StringBuilder outputText = new StringBuilder();
        boolean exceptionLetter = false;
        for (int i = 0; i < encryptedString.length(); i++) {
            char charToEncrypt = encryptedLetters[i].charAt(0);
            if (encryptedLetters[i].equals(" ")){ // Checking the space first to avoid arrayOutOfBoundException when adding the letter index
                outputText.append(encryptedLetters[i]);
                exceptionLetter = true;
                continue;
            }
            if (encryptedLetters[i].equals("!")) {
                outputText.append(encryptedLetters[i]);
                exceptionLetter = true;
                continue;
            }
            if (encryptedLetters[i].matches("\\d")) { // match any digit
                outputText.append(encryptedLetters[i]);
                exceptionLetter = true;
                continue;
            }
            char encryptedLetter = getDecryptedLetter(key, exceptionLetter, charToEncrypt);
            outputText.append(encryptedLetter);
        }
        setDecryptedText(outputText.toString());
        return outputText.toString();
    }

    private char getDecryptedLetter(int key, boolean exceptionLetter, char charToEncrypt) {
        char encryptedLetter;
        if (Character.toUpperCase(charToEncrypt) == charToEncrypt && !exceptionLetter) {
            encryptedLetter = ((charToEncrypt - key) < 65) ?
                    (char) (((charToEncrypt - key) % 65) + 26) : (char) ((charToEncrypt - key) % 65);
        } else {
            encryptedLetter = ((charToEncrypt - key) < 97) ?
                    (char) (((charToEncrypt - key) % 122) + 26) : (char) ((charToEncrypt - key) % 122);
        }
        return encryptedLetter;
    }

    public String decrypt(int key) {
        String[] decryptedLetters = encryptedString.split("");
        StringBuilder outputText = new StringBuilder();
        for (int i = 0; i < encryptedString.length(); i++) {
            char charToEncrypt = decryptedLetters[i].charAt(0);
            outputText.append((char) (charToEncrypt - key));
        }
        setDecryptedText(outputText.toString());
        return outputText.toString();
    }

    public void setDecryptedText(String decryptedText) {
        this.decryptedText = decryptedText;
    }

    public String getDecryptedText() {
        return decryptedText;
    }
}

