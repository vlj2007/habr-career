package my.code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import my.code.exception.ScraperException;
import my.code.model.Company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import my.code.api.CompanyScraper;
import my.code.utils.JsoupCompanyScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Main {

    private static final String URL = "https://career.habr.com/companies?city_id=717";
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Запуск приложения");

        // Создать фильтрованный файл, там где есть ссылка на вакансии
        CompanyScraper scraper = new JsoupCompanyScraper();

        try {
            // Получение всех компаний

            List<Company> allCompanies = scraper.scrape(URL);
            //logger.info("Получение списка всех компаний : {}", allCompanies);
            logger.info("Получение списка всех компаний");

// Фильтрация и сохранение
            List<Company> filteredCompanies = allCompanies.stream()
                    .filter(c -> c.getLinks() != null && !c.getLinks().equalsIgnoreCase("N/A"))
                    .collect(Collectors.toList());

//            logger.info("Фильтрация компаний, только ссылками, размер букв не учитывается : {}", filteredCompanies);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
            String timestamp = LocalDateTime.now().format(formatter);
            String fileName = "CareerFiltered_" + timestamp + ".json";

            try (FileWriter writer = new FileWriter(fileName)) {
                gson.toJson(filteredCompanies, writer);
                logger.info("Файл готов : {}", fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при выполнении записи в файл: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (ScraperException e) {
            System.err.println("Ошибка при выполнении программы: " + e.getMessage());
            e.printStackTrace();
        }
        logger.info("Работа завершена");
    }
}
