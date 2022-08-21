import config.GetData;
import config.Hibernate;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        GetData.getData();
        Hibernate.getSessionFactory().openSession().isOpen();
    }
}
