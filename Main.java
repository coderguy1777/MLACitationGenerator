import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane parserStage = new StackPane();

        Button newCitation = new Button("Generate an MLA Citation");
        newCitation.setMaxWidth(200);
        newCitation.setMaxHeight(50);
        newCitation.setTranslateX(200);
        parserStage.getChildren().add(newCitation);

        TextField parta = new TextField();
        parta.setMaxWidth(150);
        parta.setMaxHeight(50);
        parta.setEditable(true);

        Scene scene = new Scene(parserStage, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        primaryStage.setTitle("MLA Citation Generator.");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[]args) {
        launch(args);
    }
}