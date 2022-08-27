package io.github.shirohoo.addressbook;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HashFunctionTests {
    @Test
    void hashing() {
        String hashcode = HashFunction.hashing("hello");
        assertTrue(hashcode.matches("^[0-9a-f]{64}$"));
    }
}
