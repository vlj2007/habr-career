package my.code.utils;

import my.code.api.CompanyScraper;
import my.code.exception.ScraperException;
import my.code.model.Company;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JsoupCompanyScraper implements CompanyScraper {
    private static final int MAX_RETRIES = 5;
    private static final int TIMEOUT = 4000;
    private static final Random RANDOM = new Random();

    @Override
    public List<Company> scrape(String url) throws ScraperException {
        List<Company> companyList = new ArrayList<>();

        while (url != null) {
            boolean successful = false;
            int attempt = 0;

            while (!successful && attempt < MAX_RETRIES) {
                try {
                    Connection connection = Jsoup.connect(url)
                            .referrer("www.google.com")
                            .ignoreContentType(true)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
                                    "(KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36 YandexBrowser/123.0.0.0")
                            .timeout(TIMEOUT)
                            .followRedirects(true);

                    Document doc = connection.get();

                    Elements careerElements = doc.select("div.inner");

                    for (Element careerElement : careerElements) {
                        String title = getTextOrDefault(careerElement, "a.title", "N/A");
                        String rating = getTextOrDefault(careerElement, "span.rating", "N/A");
                        String vacancies = getTextOrDefault(careerElement, "div.vacancies_count > a", "N/A");
                        String skills = getTextOrDefault(careerElement, "div.skills", "N/A");

                        Element linkElement = careerElement.selectFirst("div > div > div.vacancies_count > a");
                        String links = linkElement != null ? "https://career.habr.com" + linkElement.attr("href") : "N/A";

                        Company company = new Company(title, rating, vacancies, skills, links);
                        companyList.add(company);
                    }

                    Element nextButton = doc.selectFirst("a.page.next");
                    if (nextButton != null) {
                        String href = nextButton.attr("href");
                        if (!href.startsWith("http")) {
                            URI baseUri = URI.create(url);
                            URI resolved = baseUri.resolve(href);
                            url = resolved.toString();
                        } else {
                            url = href;
                        }
                    } else {
                        url = null;
                    }
                    successful = true;
                    Thread.sleep(2000 + RANDOM.nextInt(3000));
                } catch (Exception e) {
                    attempt++;
                    System.err.printf("Error (%d/%d) fetching page %s: %s%n", attempt, MAX_RETRIES, url, e.getMessage());
                    if (attempt >= MAX_RETRIES) {
                        throw new ScraperException("Max attempts reached for url: " + url, e);
                    }
                    try {
                        Thread.sleep(2000 + RANDOM.nextInt(1000));
                    } catch (InterruptedException ie) {
                        Thread.currentThread().interrupt();
                        throw new ScraperException("Thread interrupted", ie);
                    }
                }
            }
        }
        return companyList;
    }

    private String getTextOrDefault(Element element, String cssQuery, String defaultValue) {
        Element found = element.selectFirst(cssQuery);
        return found != null ? found.text() : defaultValue;
    }

    @Override
    public List<Company> scraper(String url) throws ScraperException {
        return List.of();
    }
}
