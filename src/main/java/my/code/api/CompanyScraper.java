package my.code.api;

import my.code.exception.ScraperException;
import my.code.model.Company;

import java.util.List;

public interface CompanyScraper {
    List<Company> scraper(String url) throws ScraperException;
}
