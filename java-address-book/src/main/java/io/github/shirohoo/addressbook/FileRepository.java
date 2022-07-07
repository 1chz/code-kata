package io.github.shirohoo.addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;

final class FileRepository {
    private final FileManager fileManager;

    public FileRepository(FileManager fileManager) {
        if (Files.notExists(fileManager.rootPath)) {
            try {
                Files.createDirectories(fileManager.rootPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        this.fileManager = fileManager;
    }

    public void save(Data data) {
        String hash = HashFunction.digest(data.id);
        String filePath = fileManager.getFilePath(hash);

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)))) {
            bw.write(data.toString());
            bw.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String find(String id) {
        String filePath = fileManager.getFilePath(id);

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            return br.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
