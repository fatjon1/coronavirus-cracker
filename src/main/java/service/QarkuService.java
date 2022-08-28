package service;

import dao.QarkuDaoImpl;
import model.Qarku;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class QarkuService {

    private static QarkuDaoImpl qarkuDao = new QarkuDaoImpl();


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


    public List<Qarku> findQarkuByName(String name) {
        qarkuDao.openCurrentSession();
        List<Qarku> qarku = qarkuDao.findByQarkuName(name);
        qarkuDao.closeCurrentSession();
        return qarku;
    }

    public void deleteAll() {
        qarkuDao.openCurrentSessionwithTransaction();
        qarkuDao.deleteAll();
        qarkuDao.closeCurrentSessionwithTransaction();
    }

    public void saveAll(List<Qarku> qarku) {
        qarkuDao.openCurrentSessionwithTransaction();
        qarkuDao.saveAll(qarku);
        qarkuDao.closeCurrentSessionwithTransaction();
    }

    public List<Qarku> qarkuMeShumeInfektime(){
        List<Qarku> val = findAll().stream().collect(Collectors.groupingBy(
                        Qarku::getRaste_gjithsej,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .lastEntry()
                .getValue();
        return val;
    }

    public void findByCity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("vendos qytetin: ");
        String city = scanner.nextLine();
        if (findQarkuByName(city).isEmpty()){
            System.out.println("Qyteti nuk u gjend!");
        }else {
            System.out.println(findQarkuByName(city));
        }

    }

}
