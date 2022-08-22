import config.GetData;
import model.Qarku;
import service.QarkuService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

         GetData.getData();
         /*
         {
          "ID":"1",
          "qarku":"Berat",
          "raste_gjithsej":"15478",
          "sheruar":"15191",
          "vdekur":"175",
          "akt_pozitive":"112",
          "terapi_int":"0",
          "mjekim_spitalor":"2",
          "izolim":"110",
          "teste":"43062",
          "lat":"40.71000700",
          "lon":"19.94577900"
          }
          */


         //TODO: mapimi i te dhenave te meren nga metoda getData dhe ruajtja ne database
         //TODO: ne momentin qe startohet app metoda me siper behet run dhe behet reset database
         // duke ruajtur te dhenat e perditesuara.

        Qarku[] qarqet = GetData.getData();
        //Qarku fier = new Qarku(1L,"fier",1,1,1,1,1,1,1,1,"1","1");
        System.out.println(Arrays.stream(qarqet).findFirst().get().qarku);
        QarkuService qarkuService = new QarkuService();
       // qarkuService.persist(fier);
        for (Qarku q:qarqet
             ) {
            qarkuService.persist(q);
        }



    }
}
