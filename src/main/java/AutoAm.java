import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by harut on 5/9/17.
 */
public class AutoAm extends Application {
    Pane pane;
    FlowPane root;
    ScrollPane scrollPane;


    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("auto.am Parser");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();


    }

    private Parent createContent() {
        pane = new Pane();
        scrollPane = new ScrollPane();
        root = new FlowPane();
        root.setOrientation(Orientation.HORIZONTAL);
        root.setPrefSize(400,800);
        pane.setPrefSize(400,800);
        scrollPane.setPrefSize(400,800);

        Content.content().forEach(car -> {

            Text title = new Text(car.getTitle());
            Text year = new Text("Year: " + car.getYear());
            Text price = new Text("Price: " + car.getPrice());
            ImageView image = new ImageView(car.getImage());

            FlowPane mainpane = new FlowPane();
            mainpane.setOrientation(Orientation.HORIZONTAL);
            mainpane.setMargin(image,new Insets(0,40,0,0));

            FlowPane desc = new FlowPane();
            desc.setOrientation(Orientation.VERTICAL);

            mainpane.getChildren().addAll(image,desc);

            desc.getChildren().addAll(title,year,price);

            root.getChildren().addAll(mainpane);

        });

        scrollPane.setContent(root);

        pane.getChildren().addAll(root,scrollPane);

        return pane;
    }


    public static void main(String[] args) {
        launch(args);
    }


}
