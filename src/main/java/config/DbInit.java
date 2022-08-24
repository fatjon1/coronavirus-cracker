package config;
import lombok.SneakyThrows;
import model.Qarku;
import service.QarkuService;
import java.util.List;


public class DbInit {

    @SneakyThrows
    public static void run() {
        QarkuService qarkuService = new QarkuService();

            List<Qarku> qarqet = GetData.getData();
            qarkuService.saveAll(qarqet);
    }
}
