package my.code.utils;

import my.code.exception.JsonWriteException;
import my.code.model.Company;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GsonJsonFileWriterTest {

    private static final String TEST_FILE = "test_companies.json";

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(TEST_FILE));
    }

    @Test
    void write_validData_createsFile() throws JsonWriteException, IOException {
        GsonJsonFileWriter<Company> writer = new GsonJsonFileWriter<>();

        List<Company> companies = List.of(
                new Company("Test Company", "8", "100", "Java, Python", "http://example.com")
        );

        writer.write(companies, TEST_FILE);

        assertTrue(Files.exists(Paths.get(TEST_FILE)));

        String content = Files.readString(Paths.get(TEST_FILE));
        assertTrue(content.contains("Test Company"));
        assertTrue(content.contains("Java, Python"));
    }

    @Test
    void write_invalidFilePath_throwsException() {
        GsonJsonFileWriter<Company> writer = new GsonJsonFileWriter<>();

        List<Company> companies = Collections.emptyList();

        assertThrows(JsonWriteException.class, () -> {
            writer.write(companies, "/invalid_path/test.json");
        });
    }
}