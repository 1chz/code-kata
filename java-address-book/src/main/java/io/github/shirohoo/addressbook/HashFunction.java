package io.github.shirohoo.addressbook;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashFunction {
    private static final String ALGORITHM = "SHA-256";

    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    private HashFunction() {}

    public static String hashing(String content) {
        MessageDigest md = getMessageDigest();
        byte[] digest = md.digest(content.getBytes());
        return bytesToHex(digest);
    }

    private static MessageDigest getMessageDigest() {
        try {
            return MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            // never happens
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hex = new char[bytes.length * 2];
        int i = 0;
        for (byte aByte : bytes) {
            hex[i++] = HEX_CHARS[(aByte & 0xF0) >>> 4]; // 0xF0 = 1111 0000
            hex[i++] = HEX_CHARS[aByte & 0x0F]; // 0x0F = 0000 1111
        }
        return new String(hex);
    }
}
