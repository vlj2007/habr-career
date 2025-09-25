package my.code.api;

import my.code.exception.JsonWriteException;

import java.util.List;

public interface JsonFileWriter<T> {
    void write(List<T> data, String filename) throws JsonWriteException;

}
