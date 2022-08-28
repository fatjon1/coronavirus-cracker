package dao;

import config.Hibernate;
import config.MySession;
import lombok.Data;
import model.Qarku;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

@Data
public class QarkuDaoImpl extends MySession implements Dao<Qarku, Long>{


    public void persist(Qarku entity) {
        getCurrentSession().save(entity);
    }


    public void saveAll(List<Qarku> entity) {
        entity.forEach(e->getCurrentSession().save(e));
    }


    public void update(Qarku entity) {getCurrentSession().update(entity);
    }


    public Qarku findById(Long id) {
        Qarku qarku = (Qarku) getCurrentSession().get(Qarku.class, id);
        return qarku;
    }


    // kjo metode selekton qarkun sipas emrit
    public List<Qarku> findByQarkuName(String qarku) {
        String hql = "FROM Qarku Q WHERE Q.qarku = :qarku";
        Query query = getCurrentSession().createQuery(hql);
        query.setParameter("qarku",qarku);
        return query.getResultList();
    }

    public void delete(Qarku entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Qarku> findAll() {
        List<Qarku> books = (List<Qarku>) getCurrentSession().createQuery("from Qarku").list();
        return books;
    }

    public void deleteAll() {
        List<Qarku> entityList = findAll();
        for (Qarku entity : entityList) {
            delete(entity);
        }
    }
}