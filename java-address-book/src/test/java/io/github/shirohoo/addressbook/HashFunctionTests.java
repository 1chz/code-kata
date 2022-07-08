package io.github.shirohoo.addressbook;

import org.junit.jupiter.api.Test;

import static io.github.shirohoo.addressbook.HashFunction.hashing;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HashFunctionTests {
    @Test
    void digest() {
        String hashcode = hashing("hello");
        assertEquals("2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824", hashcode);
    }
}