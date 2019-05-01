import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.awt.*;
import java.io.*;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // scene stackpane for parser
        StackPane parserStage = new StackPane();
        /*
            Layout of citation generator.
         */

        // new citation button
        Button bookCitation = new Button("Generate an MLA Citation for a Book");
        bookCitation.setMaxWidth(200);
        bookCitation.setMaxHeight(50);
        bookCitation.setFont(new Font("Arial", 10));
        bookCitation.setTranslateX(200);
        bookCitation.setTranslateY(-85.0);
        parserStage.getChildren().add(bookCitation);

        // citation for site
        Button siteCitation = new Button("Generate an MLA Citation for a Website");
        siteCitation.setMaxWidth(200);
        siteCitation.setMaxHeight(50);
        siteCitation.setFont(new Font("Arial", 10));
        siteCitation.setTranslateX(200);
        siteCitation.setTranslateY(-5.0);
        parserStage.getChildren().add(siteCitation);

        /*
            text input fields
         */

        // Author textfield
        TextField parta = new TextField();
        parta.setMaxWidth(150);
        parta.setMaxHeight(25);
        parta.setEditable(true);
        parta.setTranslateX(-250);
        parserStage.getChildren().add(parta);

        // Publisher textfield
        TextField partb = new TextField();
        partb.setMaxHeight(25);
        partb.setMaxWidth(150);
        partb.setEditable(true);
        partb.setTranslateX(-250);
        partb.setTranslateY(80);
        parserStage.getChildren().add(partb);

        // Year source was published
        TextField partc = new TextField();
        partc.setMaxHeight(25);
        partc.setMaxWidth(150);
        partc.setEditable(true);
        partc.setTranslateX(-250);
        partc.setTranslateY(-80);
        parserStage.getChildren().add(partc);

        // Title of the source.
        TextField partd = new TextField();
        partd.setMaxHeight(25);
        partd.setMaxWidth(150);
        partd.setTranslateX(-250);
        partd.setTranslateY(-160);
        partd.setEditable(true);
        parserStage.getChildren().add(partd);

        // label for author source
        Label partA = new Label("Author of source");
        partA.setFont(new Font("Arial", 15));
        partA.setTranslateX(-250);
        partA.setTranslateY(-25);
        parserStage.getChildren().add(partA);

        // label for published of source
        Label partB = new Label("Publisher of source");
        partB.setFont(new Font("Arial", 15));
        partB.setTranslateX(-250);
        partB.setTranslateY(55);
        parserStage.getChildren().add(partB);

        // label for source publish year
        Label partC = new Label("Year source was published");
        partC.setFont(new Font("Arial", 15));
        partC.setTranslateX(-250);
        partC.setTranslateY(-105);
        parserStage.getChildren().add(partC);

        // label for source title
        Label partD = new Label("Title of source");
        partD.setFont(new Font("Arial", 15));
        partD.setTranslateX(-250);
        partD.setTranslateY(-185);
        parserStage.getChildren().add(partD);

        MLA mla = new MLA(2002, "Hello", "Steve", "Steve Rogers", "Hello");
        mla.generateMLAName();


        Scene scene = new Scene(parserStage, 800, 600);
        scene.setFill(Color.rgb(188, 129, 98));
        parserStage.setId("Color1");
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setTitle("MLA Citation Generator.");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[]args) {
        launch(args);
    }
}