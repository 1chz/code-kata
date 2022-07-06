package io.github.shirohoo.addressbook;

import static java.util.stream.Collectors.joining;
import java.io.File;

final class FileManager {
    String getFilePath(String hash) {
        return "%s%s%s".formatted(pathFrom(hash), File.separator, hash);
    }

    private String pathFrom(String hash) {
        return hash.chars()
                .mapToObj(String::valueOf)
                .collect(joining(File.separator));
    }
}
