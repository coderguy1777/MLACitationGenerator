import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;

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
        parta.setMaxHeight(25);
        parta.setEditable(true);
        parta.setTranslateX(-250);
        parserStage.getChildren().add(parta);

        TextField partb = new TextField();
        partb.setMaxHeight(25);
        partb.setMaxWidth(150);
        partb.setEditable(true);
        partb.setTranslateX(-250);
        partb.setTranslateY(80);
        parserStage.getChildren().add(partb);

        TextField partc = new TextField();
        partc.setMaxHeight(25);
        partc.setMaxWidth(150);
        partc.setEditable(true);
        partc.setTranslateX(-250);
        partc.setTranslateY(-80);
        parserStage.getChildren().add(partc);

        TextField partd = new TextField();
        partd.setMaxHeight(25);
        partd.setMaxWidth(150);
        partd.setTranslateX(-250);
        partd.setTranslateY(-160);
        partd.setEditable(true);
        parserStage.getChildren().add(partd);

        Label partA = new Label("Author of source");
        partA.setFont(new Font("Arial", 15));
        partA.setTranslateX(-250);
        partA.setTranslateY(-25);
        parserStage.getChildren().add(partA);

        Label partB = new Label("Publisher of source");
        partB.setFont(new Font("Arial", 15));
        partB.setTranslateX(-250);
        partB.setTranslateY(55);
        parserStage.getChildren().add(partB);

        Label partC = new Label("Year source was published");
        partC.setFont(new Font("Arial", 15));
        partC.setTranslateX(-250);
        partC.setTranslateY(-105);
        parserStage.getChildren().add(partC);

        Label partD = new Label("Title of source");
        partD.setFont(new Font("Arial", 15));
        partD.setTranslateX(-250);
        partD.setTranslateY(-185);
        parserStage.getChildren().add(partD);

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