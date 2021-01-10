package pl.sda.livecodingspringcore.repository;

import java.util.List;

public interface DataRepository<T> {
    List<T> findAll();

    void save(T blogPost);
}
