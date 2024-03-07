package com.leiton.ejercicioLogin.utils;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtils {
    
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";

    public static String encrypt(String input) throws GeneralSecurityException, UnsupportedEncodingException {
        Cipher cipher;
        cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, generateKey(128), generateIv());
        byte[] cipherText;
        cipherText = cipher.doFinal(input.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(cipherText);
    }

    private static SecretKey generateKey (int n) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(n);
        return keyGenerator.generateKey();
    }

    private static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}
