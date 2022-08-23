package service;

import dao.QarkuDao;
import dao.QarkuDaoImpl;
import model.Qarku;
import java.util.List;
public class QarkuService {

    private static QarkuDaoImpl qarkuDao;

    public QarkuService() {
        qarkuDao = new QarkuDaoImpl();
    }

    public void persist(Qarku entity) {
        qarkuDao.openCurrentSessionwithTransaction();
        qarkuDao.persist(entity);
        qarkuDao.closeCurrentSessionwithTransaction();
    }

    public void update(Qarku entity) {
        qarkuDao.openCurrentSessionwithTransaction();
        qarkuDao.update(entity);
        qarkuDao.closeCurrentSessionwithTransaction();
    }

    public Qarku findById(Long id) {
        qarkuDao.openCurrentSession();
        Qarku book = qarkuDao.findById(id);
        qarkuDao.closeCurrentSession();
        return book;
    }

    public void delete(Long id) {
        qarkuDao.openCurrentSessionwithTransaction();
        Qarku book = qarkuDao.findById(id);
        qarkuDao.delete(book);
        qarkuDao.closeCurrentSessionwithTransaction();
    }

    public List<Qarku> findAll() {
        qarkuDao.openCurrentSession();
        List<Qarku> qarqet = qarkuDao.findAll();
        qarkuDao.closeCurrentSession();
        return qarqet;
    }

    public void deleteAll() {
        qarkuDao.openCurrentSessionwithTransaction();
        qarkuDao.deleteAll();
        qarkuDao.closeCurrentSessionwithTransaction();
    }

    public void saveAll(List<Qarku> qarku) {
        qarkuDao.openCurrentSession();
        qarkuDao.saveAll(qarku);
        qarkuDao.closeCurrentSession();
    }
}
