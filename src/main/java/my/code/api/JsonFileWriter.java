package my.code.api;

import my.code.exception.JsonWriteException;

import java.util.List;

/**
 * Интерфейс для записи результата в файл.
 * Определяет метод для записи в файл.
 *
 * @author Vlj2007
 * @version 0.1
 */

public interface JsonFileWriter<T> {

    /**
     * Запись результата в файл с заданными параметрами.
     *
     * @param data     список компаний
     * @param filename название файла
     * @throws JsonWriteException если данные не найдены
     */

    void write(List<T> data, String filename) throws JsonWriteException;

}
