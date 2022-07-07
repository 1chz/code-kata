package io.github.shirohoo.addressbook;

import java.io.File;
import java.nio.file.Path;

final class FileManager {
    public final Path rootPath;

    public FileManager(Path root) {
        this.rootPath = root;
    }

    String getFilePath(String file) {
        return rootPath.toString() + File.separator + file;
    }
}
