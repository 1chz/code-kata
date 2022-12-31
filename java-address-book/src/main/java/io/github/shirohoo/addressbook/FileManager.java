package io.github.shirohoo.addressbook;

import static io.github.shirohoo.addressbook.HashFunction.hashing;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

final class FileManager {
    private final Path rootPath;

    public FileManager(Path rootPath) {
        if (Files.notExists(rootPath)) {
            try {
                Files.createDirectories(rootPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.rootPath = rootPath;
    }

    public void save(Data data) {
        String hash = hashing(data.id);
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getFilePath(hash))))) {
            bw.write(data.toString());
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String find(String id) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(getFilePath(id))))) {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getFilePath(String file) {
        return rootPath.toString() + File.separator + file;
    }
}
