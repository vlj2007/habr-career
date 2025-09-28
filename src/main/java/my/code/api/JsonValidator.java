package my.code.api;

/**
 * Интерфейс для проверки валидации результата.
 * Определяет метод для валидации.
 *
 * @author Vlj2007
 * @version 0.1
 */

public interface JsonValidator {

    /**
     * Проверка валидации результата в файл с заданными параметрами.
     *
     * @param filename название файла
     */

    boolean validate(String filename);
}
