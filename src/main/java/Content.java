import javafx.scene.image.Image;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by harut on 5/9/17.
 */
public class Content {
   static Document document;
   private static String image;
   private static String title;
   private static String price;
   private static String year;
   private static String link;
   private static List<Car> cars = new ArrayList<>();
   private static  int count = 0;

   public static List<Car> content() {

      try {
          document = Jsoup.connect("https://auto.am/").get();
          Elements elements = document.getElementsByAttributeValue("class","card");
          elements.forEach(element -> {
              count++;
              if (count >= 50)
                  return;
              System.out.println(title);
              link = String.format("https://auto.am%s",element.child(0).attr("href"));
              title = element.getElementsByAttributeValue("class","card-title bold").text();
              year = element.getElementsByAttributeValue("class","bold").text();
              price = element.getElementsByAttributeValue("class","price right").text();
              image = "https://auto.am" + element.getElementsByAttributeValue("class","flipimg").attr("src");
               Image img = new Image(image);
              cars.add(new Car(link,title,price,year, img));

          });

      } catch (IOException e) {
            e.printStackTrace();
      }

      return cars;
   }




}
