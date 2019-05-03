import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.*;
import java.awt.*;
import java.util.ArrayList;

public class Main extends Application {
    public static ArrayList<MLA>bookCitations = new ArrayList<>();
    public static ArrayList<MLA>webCitations = new ArrayList<>();
    public static ArrayList<String>HTMLBooks = new ArrayList<>();
    public static ArrayList<String>HTMLWeb = new ArrayList<>();
    public static int currentCitations = 0;

    public static void citeSource(MLA a) {
        if(a.sourceurl == ' ') {
            bookCitations.add(a);
            HTMLBooks.add(a.generateMLABookCitation());
        } else if(a.sourceurl != ' ') {
            webCitations.add(a);
            HTMLWeb.add(a);
        }
    }

    public static void writeUsingFileWriter(String data) {
        File file = new File("Filetest" + currentCitations + ".html");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // scene stackpane for parser
        StackPane parserStage = new StackPane();
        /*
            Layout of citation generator.
         */

        // new citation button
        Button bookCitation = new Button("Generate MLA Citations for Books");
        bookCitation.setMaxWidth(200);
        bookCitation.setMaxHeight(50);
        bookCitation.setFont(new Font("Arial", 10));
        bookCitation.setTranslateX(200);
        bookCitation.setTranslateY(-85.0);
        parserStage.getChildren().add(bookCitation);

        // citation for site
        Button siteCitation = new Button("Generate MLA Citations for Websites");
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
        TextField parta = new TextField("Author");
        parta.setMaxWidth(150);
        parta.setMaxHeight(25);
        parta.setEditable(true);
        parta.setTranslateX(-250);
        parserStage.getChildren().add(parta);

        // Publisher textfield
        TextField partb = new TextField("Publisher");
        partb.setMaxHeight(25);
        partb.setMaxWidth(150);
        partb.setEditable(true);
        partb.setTranslateX(-250);
        partb.setTranslateY(80);
        parserStage.getChildren().add(partb);

        // Year source was published
        TextField partc = new TextField("Year of Publishing");
        partc.setMaxHeight(25);
        partc.setMaxWidth(150);
        partc.setEditable(true);
        partc.setTranslateX(-250);
        partc.setTranslateY(-80);
        parserStage.getChildren().add(partc);

        // Title of the source.
        TextField partd = new TextField("Source title");
        partd.setMaxHeight(25);
        partd.setMaxWidth(150);
        partd.setTranslateX(-250);
        partd.setTranslateY(-160);
        partd.setEditable(true);
        parserStage.getChildren().add(partd);

        // prepares info for citation

        bookCitation.setOnAction(actionEvent -> {
            String author = "  ";
            String sourcetitle = " ";
            String sourceurl = " ";
            String publisher = "";
            int publishyear = 0;
            parta.setEditable(false);
            partb.setEditable(false);
            partc.setEditable(false);
            partd.setEditable(false);
            if(!(parta.getText().isEmpty())) {
                author = parta.getText();
            }

            if(!(partb.getText().isEmpty())) {
                publisher = partb.getText();
            }

            if(!(partc.getText().isEmpty())) {
                publishyear = new Integer(partc.getText());
            }

            if(!(partd.getText().isEmpty())) {
                sourcetitle = partd.getText();
            }
            MLA Cited = new MLA(publishyear, sourcetitle, publisher, author, sourceurl);
            currentCitations++;
            System.out.println(Cited.generateMLABookCitation());
        });

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

        MLA mla = new MLA(2019, "Air Force Leader: Artificial Intelligence Could Help Monitor Social Media", "The New York Times", "John Markoff", "https://www.nytimes.com/2019/04/25/obituaries/nils-nilssen-dead.html?rref=collection%2Ftimestopic%2FArtificial%20Intelligence&action=click&contentCollection=timestopics&region=stream&module=stream_unit&version=latest&contentPlacement=1&pgtype=collection");
        mla.generateMLAName();
        mla.generateMLATitle();

        String mlaCitation = mla.generateMLABookCitation();
        writeUsingFileWriter(mlaCitation);
        System.out.println(mlaCitation);

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