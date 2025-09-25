package my.code.utils;

import my.code.api.CompanyScraper;
import my.code.exception.ScraperException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsoupCompanyScraperTest {

    @Test
    void scrape_invalidUrl_throwsScraperException() {
        CompanyScraper scraper = new JsoupCompanyScraper();

        String invalidUrl = "http://invalid.url";

        ScraperException exception = assertThrows(ScraperException.class, () -> {
            scraper.scrape(invalidUrl);
        });

        assertTrue(exception.getMessage().contains("Max attempts reached"));
    }
}