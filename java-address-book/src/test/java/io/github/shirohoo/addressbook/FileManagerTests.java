package io.github.shirohoo.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

class FileManagerTests {
    @Test
    void getFilePath() {
        // given
        Path root = Paths.get("src", "main", "resources", "addressbook");
        FileManager fileManager = new FileManager(root);
        String hash = "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824";

        // when
        String filePath = fileManager.getFilePath(hash);

        // then
        String expected = "src"
                + File.separator
                + "main"
                + File.separator
                + "resources"
                + File.separator
                + "addressbook"
                + File.separator
                + "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824";

        assertEquals(expected, filePath);
    }
}