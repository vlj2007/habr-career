package my.code.utils;

import my.code.api.JsonValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class GsonJsonValidatorTest {

    private static final String VALID_JSON_FILE = "valid.json";
    private static final String INVALID_JSON_FILE = "invalid.json";

    @BeforeEach
    void setup() throws IOException {
        Files.writeString(Paths.get(VALID_JSON_FILE), "[{\"title\":\"Test\"}]");
        Files.writeString(Paths.get(INVALID_JSON_FILE), "{invalid json}");
    }

    @AfterEach
    void cleanup() throws IOException {
        Files.deleteIfExists(Paths.get(VALID_JSON_FILE));
        Files.deleteIfExists(Paths.get(INVALID_JSON_FILE));
    }

    @Test
    void validate_validJson_returnsTrue() {
        JsonValidator validator = new GsonJsonValidator();
        assertTrue(validator.validate(VALID_JSON_FILE));
    }

    @Test
    void validate_invalidJson_returnsFalse() {
        JsonValidator validator = new GsonJsonValidator();
        assertFalse(validator.validate(INVALID_JSON_FILE));
    }
}