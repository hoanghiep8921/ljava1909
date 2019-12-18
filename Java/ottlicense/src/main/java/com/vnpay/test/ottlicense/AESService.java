package com.vnpay.test.ottlicense;

/**
 *
 * @author quangtt
 */

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * https://www.owasp.org/index.php/Using_the_Java_Cryptographic_Extensions
 *
 *
 */
public class AESService {
    public static final int AES_KEYLENGTH = 128;
    public static final int IV_LENGTH = 16;

    public static byte[] generateIV() {
        byte[] iv = new byte[IV_LENGTH];
        SecureRandom prng = new SecureRandom();
        prng.nextBytes(iv);
        
        return iv;
    }

    public static byte[] encrypt(String strSecretKey, String text, byte[] iv) throws Exception {
        byte[] encodedKey = strSecretKey.getBytes();
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher aesCipherForEncryption = Cipher.getInstance("AES/CTR/NoPadding");
        aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] byteDataToEncrypt = text.getBytes("UTF-8");
        byte[] byteCipherText = aesCipherForEncryption
                .doFinal(byteDataToEncrypt);
        return byteCipherText;

    }
    
    public static byte[] encryptByte(String strSecretKey, byte[] byteDataToEncrypt, byte[] iv) throws Exception {
        byte[] encodedKey = strSecretKey.getBytes();
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher aesCipherForEncryption = Cipher.getInstance("AES/CTR/NoPadding");
        aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        
        byte[] byteCipherText = aesCipherForEncryption
                .doFinal(byteDataToEncrypt);
        return byteCipherText;

    }
    
    

    public static String decrypt(String strSecretKey, byte[] textByte, byte[] iv) throws Exception {
        byte[] encodedKey = strSecretKey.getBytes();
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher aesCipherForDecryption = Cipher.getInstance("AES/CTR/NoPadding");

        aesCipherForDecryption.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));

        byte[] byteCipherText = aesCipherForDecryption
                .doFinal(textByte);
        String strCipherText = new String(byteCipherText, "UTF-8");
        return strCipherText;


    }
    
    public static byte[] decryptByte(String strSecretKey, byte[] textByte, byte[] iv) throws Exception {
        byte[] encodedKey = strSecretKey.getBytes();
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher aesCipherForDecryption = Cipher.getInstance("AES/CTR/NoPadding");

        aesCipherForDecryption.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));

        byte[] byteCipherText = aesCipherForDecryption
                .doFinal(textByte);
        
        return byteCipherText;


    }
    
    
    public static String encrypt(String strSecretKey, String text) throws Exception {
        byte[] encodedKey = strSecretKey.getBytes("UTF-8");//Base64.decode(strSecretKey.getBytes("UTF-8"));
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher aesCipherForEncryption = Cipher.getInstance("AES/CTR/NoPadding");
        byte[] iv = new byte[AES_KEYLENGTH / 8];
        SecureRandom prng = new SecureRandom();
        prng.nextBytes(iv);
        aesCipherForEncryption.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] byteDataToEncrypt = text.getBytes("UTF-8");
        byte[] byteCipherText = aesCipherForEncryption
                .doFinal(byteDataToEncrypt);
        byte[] finalEncrypt = new byte[AES_KEYLENGTH / 8 + byteCipherText.length];
        System.arraycopy(iv, 0, finalEncrypt, 0, AES_KEYLENGTH / 8);
        System.arraycopy(byteCipherText, 0, finalEncrypt, AES_KEYLENGTH / 8, byteCipherText.length);
        String strCipherText = Base64.getEncoder().encodeToString(finalEncrypt);
        return strCipherText;
    }

    public static String decrypt(String strSecretKey, String text) throws Exception {
        byte[] encodedKey = strSecretKey.getBytes("UTF-8");//Base64.decode(strSecretKey.getBytes("UTF-8"));
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        Cipher aesCipherForDecryption = Cipher.getInstance("AES/CTR/NoPadding");
        byte[] byteDataToEncrypt0 = Base64.getDecoder().decode(text);
        byte[] iv = Arrays.copyOfRange(byteDataToEncrypt0, 0, 16);
        aesCipherForDecryption.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] byteDataToEncrypt = Arrays.copyOfRange(byteDataToEncrypt0, 16, byteDataToEncrypt0.length);
        byte[] byteCipherText = aesCipherForDecryption
                .doFinal(byteDataToEncrypt);
        String strCipherText = new String(byteCipherText, "UTF-8");
        return strCipherText;
    }

}
