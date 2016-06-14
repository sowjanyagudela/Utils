/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author sowjanya
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

public class EncryptionDecryptionAES {

    static Cipher cipher;

    public static void main(String[] args) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("AES");

        String plainText = "https://91.203.200.117/htdocs1/3/Deluxe/Central1NormalProducts/cultbooking/cultbooking.php?agentcode=45505&hotelcode=47855&lang=en";
        System.out.println("Plain Text Before Encryption: " + plainText);

        String encryptedText = encrypt(plainText, secretKey);
        System.out.println("Encrypted Text After Encryption: " + encryptedText);

        String decryptedText = decrypt(encryptedText, secretKey);
        System.out.println("Decrypted Text After Decryption: " + decryptedText);
    }

    public static String encrypt(String plainText, SecretKey secretKey)
            throws Exception {
        byte[] plainTextByte = plainText.getBytes();
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedByte = cipher.doFinal(plainTextByte);

        String encryptedText = DatatypeConverter.printBase64Binary(encryptedByte);
       
//        Base64.Encoder encoder = Base64.getEncoder();
//        String encryptedText = encoder.encodeToString(encryptedByte);
        return encryptedText;
    }

    public static String decrypt(String encryptedText, SecretKey secretKey)
            throws Exception {
        
         byte[] encryptedTextByte = DatatypeConverter.parseBase64Binary(encryptedText);
//        Base64.Decoder decoder = Base64.getDecoder();
//        byte[] encryptedTextByte = decoder.decode(encryptedText);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        String decryptedText = new String(decryptedByte);
        return decryptedText;
    }
}
