package io.github.shirohoo.addressbook;

import java.io.File;
import java.nio.file.Path;

final class FileManager {
    private final Path rootPath;

    public FileManager(Path root) {
        this.rootPath = root;
    }

    String getFilePath(String hash) {
        return rootPath.toString() + File.separator + hash;
    }
}
