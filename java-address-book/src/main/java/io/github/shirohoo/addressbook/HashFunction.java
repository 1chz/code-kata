package io.github.shirohoo.addressbook;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashFunction {
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();
    private static final String SHA_256 = "SHA-256";

    private HashFunction() {
    }

    public static String digest(String content) {
        MessageDigest md = getMessageDigest();
        byte[] digest = md.digest(content.getBytes());
        return bytesToHex(digest);
    }

    private static MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(SHA_256);
        } catch (NoSuchAlgorithmException e) {
            // never happens
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hex = new char[bytes.length * 2];
        for (int i = 0; i < bytes.length; i++) {
            int x = bytes[i] & 0xFF;
            hex[i * 2] = HEX_CHARS[x >>> 4];
            hex[i * 2 + 1] = HEX_CHARS[x & 0x0F];
        }
        return new String(hex).toLowerCase();
    }
}
