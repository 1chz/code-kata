package io.github.shirohoo.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import org.junit.jupiter.api.Test;

class DataTests {
    @Test
    void build() {
        Data data = Data.builder()
                .id(UUID.randomUUID())
                .name("siro")
                .gender("M")
                .age(28)
                .phoneNumber("010-1234-5678")
                .address("Korea")
                .build();

        assertEquals("siro", data.name);
        assertEquals("M", data.gender);
        assertEquals(28, data.age);
        assertEquals("010-1234-5678", data.phoneNumber);
        assertEquals("Korea", data.address);
    }
}
