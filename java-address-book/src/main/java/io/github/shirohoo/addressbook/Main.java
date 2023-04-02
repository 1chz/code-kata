package io.github.shirohoo.addressbook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Path root = Paths.get(System.getProperty("user.home"), "address-book");
        FileManager fileManager = new FileManager(root);

        write(fileManager, 1_000);
        read(fileManager, "00a5c2166d5d67123a59a8620e614f714ffdc5931186752ebe21271a09da93dc");
    }

    private static void write(FileManager fileManager, int count) {
        for (int i = 0; i < count; i++) {
            Data data = Data.builder()
                    .id(UUID.randomUUID())
                    .name(String.valueOf(i))
                    .gender("M")
                    .age(1)
                    .phoneNumber("010-1234-5678")
                    .address("Korea")
                    .build();

            fileManager.save(data);
        }
    }

    private static void read(FileManager fileManager, String id) {
        String found = fileManager.find(id);
        System.out.println(found);
    }
}
