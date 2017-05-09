import javafx.scene.image.Image;

 public class Car {
    private final String title;
    private final String price;
    private final String year;
    private final Image image;
    private final String link;

    Car(String link,String title, String price, String year, Image image) {
        this.title = title;
        this.price = price;
        this.year = year;
        this.image = image;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getYear() {
        return year;
    }

    public Image getImage() {
        return image;
    }

    public String getLink() {
        return link;
    }

     @Override
     public String toString() {
         return "Car{" +
                 "title='" + title + '\'' +
                 ", price='" + price + '\'' +
                 ", year='" + year + '\'' +
                 ", image=" + image +
                 ", link='" + link + '\'' +
                 '}';
     }
 }
