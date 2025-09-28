package my.code.exception;

/**
 * Класс для обработки исключения сбора данных с сайта.
 * Определяет метод для обработки исключения сбора данных с сайта.
 */

public class ScraperException extends Exception{

    /**
     * Обработка исключения сбора данных с сайта.
     *
     * @param message текстовое сообщение.
     * @param cause   исходное исключение.
     */

    public ScraperException(String message, Throwable cause){
        super(message, cause);
    }
}
