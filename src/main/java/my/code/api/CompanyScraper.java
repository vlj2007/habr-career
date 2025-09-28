package my.code.api;

import my.code.exception.ScraperException;
import my.code.model.Company;

import java.util.List;

/**
 * Интерфейс для сбора данных с сайта.
 * Определяет методы для сбора данных с сайта.
 * @author Vlj2007
 * @version 0.1
 */

public interface CompanyScraper {

    /**
     * Сбор данных с сайта с заданными параметрами.
     *
     * @param url адрес сайта
     * @throws ScraperException если сайт не найден
     */

    List<Company> scrape(String url) throws ScraperException;

    List<Company> scraper(String url) throws ScraperException;
}
