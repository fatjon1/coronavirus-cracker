package dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface QarkuDao <T, Id extends Serializable> {

    public void persist(T entity);
    public void saveAll(List<T> entity);

    public void update(T entity);

    public T findById(Long id);

    public List<T> findByQarku(String qarku);

    public void delete(T entity);

    public List<T> findAll();

    public void deleteAll();
}
