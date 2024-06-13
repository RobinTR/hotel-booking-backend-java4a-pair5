package com.tobeto.hotel_booking_java4a_pair5.core.utils;

import com.tobeto.hotel_booking_java4a_pair5.core.utils.exceptions.types.BusinessException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionUtil {
    private static final String AES = "AES";
    private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static String encryptCardNumber(String cardNumber, SecretKey secretKey) {
        return encrypt(cardNumber, secretKey);
    }

    public static String encryptCvv(String cvv, SecretKey secretKey) {
        return encrypt(cvv, secretKey);
    }

    public static String encrypt(String value, SecretKey secretKey) {
        try {
            Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(value.getBytes());

            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            throw new BusinessException("Encryption error: " + e.getMessage());
        }
    }

    public static SecretKey generateAESKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(256, secureRandom);

            return keyGenerator.generateKey();
        } catch (Exception e) {
            throw new BusinessException("AES key generation error: " + e.getMessage());
        }
    }
}
