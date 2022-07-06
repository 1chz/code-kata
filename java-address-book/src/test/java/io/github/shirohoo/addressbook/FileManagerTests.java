package io.github.shirohoo.addressbook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FileManagerTests {
    @Test
    void getFilePath() {
        // given
        FileManager fileManager = new FileManager();
        String hash = "2cf24dba5fb0a30e26e83b2ac5b9e29e1b161e5c1fa7425e73043362938b9824";

        // when
        String filePath = fileManager.getFilePath(hash);

        // then
        assertEquals("50\\99\\102\\50\\52\\100\\98\\97\\53\\102\\98\\48\\97\\51\\48\\101"
                + "\\50\\54\\101\\56\\51\\98\\50\\97\\99\\53\\98\\57\\101\\50\\57\\101\\49\\98\\49"
                + "\\54\\49\\101\\53\\99\\49\\102\\97\\55\\52\\50\\53\\101\\55\\51\\48\\52\\51\\51"
                + "\\54\\50\\57\\51\\56\\98\\57\\56\\50\\52\\2cf24dba5fb0a30e26e83b2ac5b9e29e1b161"
                + "e5c1fa7425e73043362938b9824", filePath);
    }
}