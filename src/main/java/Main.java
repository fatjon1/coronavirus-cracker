import config.GetData;
import config.Hibernate;
import dao.QarkuDao;
import model.Qarku;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

         GetData.getData();



    }
}
