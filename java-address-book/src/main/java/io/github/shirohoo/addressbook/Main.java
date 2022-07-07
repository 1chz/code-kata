package io.github.shirohoo.addressbook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        FileRepository repository = createRepository();
        write(repository, 10_000);
        read(repository, "00a5c2166d5d67123a59a8620e614f714ffdc5931186752ebe21271a09da93dc");
    }

    private static FileRepository createRepository() {
        Path root = Paths.get(System.getProperty("user.home"), "address-book");
        FileManager fileManager = new FileManager(root);
        return new FileRepository(fileManager);
    }

    private static void write(FileRepository repository, int count) {
        for (int i = 0; i < count; i++) {
            Data data = Data.builder()
                    .id(UUID.randomUUID())
                    .name(i + "")
                    .gender("M")
                    .age(1)
                    .phoneNumber("010-1234-5678")
                    .address("Korea")
                    .build();

            repository.save(data);
        }
    }

    private static void read(FileRepository repository, String id) {
        String found = repository.find(id);
        System.out.println(found);
    }
}
