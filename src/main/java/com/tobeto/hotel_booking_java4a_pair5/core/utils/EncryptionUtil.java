package com.tobeto.hotel_booking_java4a_pair5.core.utils;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionUtil {
    private static final String AES = "AES";
    private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static String encryptCardNumber(String cardNumber, SecretKey secretKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return encrypt(cardNumber, secretKey);
    }

    public static String encryptCvv(String cvv, SecretKey secretKey) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return encrypt(cvv, secretKey);
    }

    public static String encrypt(String value, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(value.getBytes());

        return Base64.getEncoder().encodeToString(encryptedData);
    }

    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(256, secureRandom);

        return keyGenerator.generateKey();
    }
}
