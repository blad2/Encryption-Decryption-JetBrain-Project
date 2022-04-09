package encryptdecrypt;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ClassArgument {
    private String encryptedValue;
    private String decryptedValue;
    private String algorithm = "shift";
    private String mode = "enc";
    private Integer key = 0;
    private String dataAndIn = ""; // text from the file and the program's input.
    private String out = ""; // file to the location to ADD the text
    private boolean encrypting;
    private boolean filing = false;

    ClassArgument(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                String argsValue = i + 1 < args.length ? args[i + 1] : "";
                if ("-mode".equals(args[i])) {
                    mode = argsValue;
                }
                if ("-key".equals(args[i])) {
                    key = Integer.parseInt(argsValue);
                }
                if ("-data".equals(args[i]) || "-in".equals(args[i])) {
                    if ("-data".equals(args[i])) {
                        dataAndIn = argsValue;
                    } else if ("-in".equals(args[i])){
                        dataAndIn = getTextFromFile(argsValue);
                    }
                }
                if ("-out".equals(args[i])) {
                    out = argsValue;// if this value is empty it should print to system.out.print.
                    filing = true;
                }
                if ("-alg".equals(args[i])) {
                    if ("unicode".equals(argsValue)) {
                        algorithm = "unicode";
                    }
                }
                if (filing) {
                    writeTextToFile(out);
                }
            } catch (Exception e) {
                System.out.println("Error");;
            }
        }
        processTextToModify(dataAndIn);
    }

    public String getTextFromFile(String fileName) throws Exception {
        StringBuilder result = new StringBuilder();
        try {
            Path pathToFile = Paths.get(System.getProperty("user.dir") + "/" + fileName);
            File myObj = new File(pathToFile.toString());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                result.append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new Exception();
        }
        return result.toString();
    }

    public void writeTextToFile(String fileName) throws Exception {
        try {
            processTextToModify(dataAndIn);
            FileWriter myWriter = new FileWriter(fileName);
            if (encrypting) {
                myWriter.write(encryptedValue);
            } else {
                myWriter.write(decryptedValue);
            }
            myWriter.close();
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public void processTextToModify(String dataIn) {
        if (mode.equals("enc")) {
            Encryptor encryptor = new Encryptor(dataIn);
            if (algorithm.equals("unicode")) {
                encryptedValue = encryptor.encrypt(key);
            } else {
                encryptedValue = encryptor.encryptCharLimited(key);
            }
            encrypting = true;
        } else {
            Decryptor decryptor = new Decryptor(dataIn);
            if (algorithm.equals("unicode")) {
                decryptedValue = decryptor.decrypt(key);
            } else {
                decryptedValue = decryptor.decryptCharLimited(key);
            }
        }
    }

    public String getEncryptedValue() {
        return encryptedValue;
    }

    public String getDecryptedValue() {
        return decryptedValue;
    }

    public boolean isFiling() {
        return filing;
    }

    public boolean isEncrypting() {
        return encrypting;
    }
}
