package my.code.exception;

/**
 * Класс для обработки исключения записи результата в файл.
 * Определяет метод для обработки исключения записи в файл.
 */

public class JsonWriteException extends Throwable {

    /**
     * Обработки исключения записи результата в файл.
     *
     * @param message текстовое сообщение.
     * @param cause   исходное исключение.
     */

    public JsonWriteException(String message, Throwable cause) {
        super(message, cause);
    }
}
