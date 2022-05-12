package com.mes.util;

import com.mes.exception.HashGenerationException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashGenerator {
    private HashGenerator() {
    }

    public static String generateMD5(String message) throws HashGenerationException {
        return hashString(message);
    }

    private static String hashString(String message)
            throws HashGenerationException {

        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hashedBytes = digest.digest(message.getBytes(StandardCharsets.UTF_8));

            return convertByteArrayToHexString(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new HashGenerationException("Could not generate hash from String", e);
        }
    }

    private static String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuilder stringBuffer = new StringBuilder();
        for (byte arrayByte : arrayBytes) {
            stringBuffer.append(Integer.toString((arrayByte & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }
}
