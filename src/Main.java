import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.awt.*;
import java.io.*;
import java.net.URI;
import java.util.ArrayList;

public class Main extends Application {
    private static ArrayList<String>tester = new ArrayList<>();
    private static final String tags1 = "<!DOCTYPE html> \n" + "<html> \n" + "<head> \n" + "<meta charset=utf-8> \n" + "<title>Citations</title> \n" + "</head> \n" + "<body> \n" + "<p>";
    private static final String tags2 = "</p> \n" + "</body> \n" + "</html>";
    private String test = "";
    private String finalcite = "";
    public HTMLEncoder encoder;


    private static void citationFileWriter(String data) {
        File file = new File("Sources.html");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
            fr.close();
            URI oURI = (file.toURI());
            Desktop.getDesktop().browse(oURI);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) {
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
        bookCitation.setVisible(false);
        parserStage.getChildren().add(bookCitation);

        // checks again
        Button anotherCitationBook = new Button("Another Citation?");
        anotherCitationBook.setMaxWidth(200);
        anotherCitationBook.setMaxHeight(50);
        anotherCitationBook.setFont(new Font("Arial", 15));
        anotherCitationBook.setTranslateX(200);
        anotherCitationBook.setTranslateY(85.0);
        anotherCitationBook.setVisible(false);
        parserStage.getChildren().add(anotherCitationBook);

        // prints sources
        Button printBookCited = new Button("Print your MLA Book Citations");
        printBookCited.setMaxWidth(200);
        printBookCited.setMaxHeight(50);
        printBookCited.setFont(new Font("Arial", 10));
        printBookCited.setTranslateX(200);
        printBookCited.setVisible(false);
        parserStage.getChildren().add(printBookCited);

        // citation for site
        Button siteCitation = new Button("Generate MLA Citations for Websites");
        siteCitation.setMaxWidth(200);
        siteCitation.setMaxHeight(50);
        siteCitation.setFont(new Font("Arial", 10));
        siteCitation.setTranslateX(200);
        siteCitation.setTranslateY(-5.0);
        siteCitation.setVisible(false);
        parserStage.getChildren().add(siteCitation);

        /*
            text input fields
         */

        // Author textfield
        TextField parta = new TextField("Author");
        parta.setMaxWidth(150);
        parta.setMaxHeight(25);
        parta.setEditable(true);
        parta.setVisible(false);
        parta.setTranslateX(-250);
        parserStage.getChildren().add(parta);

        // Publisher textfield
        TextField partb = new TextField("Publisher");
        partb.setMaxHeight(25);
        partb.setMaxWidth(150);
        partb.setEditable(true);
        partb.setVisible(false);
        partb.setTranslateX(-250);
        partb.setTranslateY(80);
        parserStage.getChildren().add(partb);

        // Year source was published
        TextField partc = new TextField("Year of Publishing");
        partc.setMaxHeight(25);
        partc.setMaxWidth(150);
        partc.setEditable(true);
        partc.setVisible(false);
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
        partd.setVisible(false);
        parserStage.getChildren().add(partd);

        /*
            website text input fields
         */

        // site publisher
        TextField webSitePublisher = new TextField("Site publisher");
        webSitePublisher.setMaxHeight(25);
        webSitePublisher.setMaxWidth(150);
        webSitePublisher.setEditable(true);
        webSitePublisher.setVisible(false);
        webSitePublisher.setTranslateX(-250);
        webSitePublisher.setTranslateY(80);
        parserStage.getChildren().add(webSitePublisher);

        // article or source author
        TextField siteArticleAuthor = new TextField("Sources Author");
        siteArticleAuthor.setMaxWidth(150);
        siteArticleAuthor.setMaxHeight(25);
        siteArticleAuthor.setTranslateX(-250);
        siteArticleAuthor.setEditable(true);
        siteArticleAuthor.setVisible(false);
        parserStage.getChildren().add(siteArticleAuthor);

        // website url
        TextField siteUrl = new TextField("Site Link");
        siteUrl.setMaxWidth(150);
        siteUrl.setMaxHeight(25);
        siteUrl.setTranslateX(-250);
        siteUrl.setTranslateY(160);
        siteUrl.setEditable(true);
        siteUrl.setVisible(false);
        parserStage.getChildren().add(siteUrl);

        // source site article
        TextField sourceTitle = new TextField("Source Title");
        sourceTitle.setMaxWidth(150);
        sourceTitle.setMaxHeight(25);
        sourceTitle.setTranslateX(-250);
        sourceTitle.setTranslateY(-160);
        sourceTitle.setEditable(true);
        sourceTitle.setVisible(false);
        parserStage.getChildren().add(sourceTitle);

        // year of publishing for the article
        TextField yearPublished = new TextField("Date of Publishing");
        yearPublished.setMaxWidth(150);
        yearPublished.setMaxHeight(25);
        yearPublished.setTranslateX(-250);
        yearPublished.setTranslateY(-80);
        yearPublished.setEditable(true);
        yearPublished.setVisible(false);


        // information from textfields taken to site
        bookCitation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String finalsrc = " ";
                String author = "  ";
                String sourcetitle = " ";
                String sourceurl = " ";
                String publisher = "";
                int publishyear = 0;
                parta.setEditable(false);
                partb.setEditable(false);
                partc.setEditable(false);
                partd.setEditable(false);
                if (!(parta.getText().isEmpty())) {
                    author = parta.getText();
                }

                if (!(partb.getText().isEmpty())) {
                    publisher = partb.getText();
                }

                if (!(partc.getText().isEmpty())) {
                    publishyear = new Integer(partc.getText());
                }

                if (!(partd.getText().isEmpty())) {
                    sourcetitle = partd.getText();
                }
                MLA Cited = new MLA(publishyear, sourcetitle, publisher, author, sourceurl);
                anotherCitationBook.setVisible(true);
                test += Cited.generateptags() + '\n';
                if (test.length() > 0) {
                    System.out.println(test);
                    tester.add(test);
                }
                printBookCited.setVisible(true);
                printBookCited.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        citationFileWriter(tags1 + test + tags2);
                    }
                });
            }
        });

        anotherCitationBook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                parta.setText("Author");
                partb.setText("Publisher");
                partc.setText("Year of Publishing");
                partd.setText("Source Title");
                parta.setEditable(true);
                partb.setEditable(true);
                partc.setEditable(true);
                partd.setEditable(true);
            }
        });

        /*
          LABELS FOR CITING A BOOK SOURCE IN MLA FOR THE
          PROGRAM.
        */
        // Label for author source
        Label partA = new Label("Author of source");
        partA.setFont(new Font("Arial", 15));
        partA.setTranslateX(-250);
        partA.setTranslateY(-25);
        partA.setVisible(false);
        parserStage.getChildren().add(partA);

        // label for published of source
        Label partB = new Label("Publisher of source");
        partB.setFont(new Font("Arial", 15));
        partB.setTranslateX(-250);
        partB.setTranslateY(55);
        partB.setVisible(false);
        parserStage.getChildren().add(partB);

        // label for source publish year
        Label partC = new Label("Year source was published");
        partC.setFont(new Font("Arial", 15));
        partC.setTranslateX(-250);
        partC.setTranslateY(-105);
        partC.setVisible(false);
        parserStage.getChildren().add(partC);

        // label for source title
        Label partD = new Label("Title of source");
        partD.setFont(new Font("Arial", 15));
        partD.setTranslateX(-250);
        partD.setTranslateY(-185);
        partD.setVisible(false);
        parserStage.getChildren().add(partD);

        // choice buttons
        Button bookCite = new Button("Cite a book in MLA");
        bookCite.setMaxHeight(50);
        bookCite.setMaxWidth(200);
        bookCite.setFont(new Font("Arial", 10));
        parserStage.getChildren().add(bookCite);

        bookCite.setOnAction(event -> {
            bookCite.setVisible(false);
            bookCitation.setVisible(true);
            parta.setVisible(true);
            partb.setVisible(true);
            partc.setVisible(true);
            partd.setVisible(true);
            partA.setVisible(true);
            partB.setVisible(true);
            partC.setVisible(true);
            partD.setVisible(true);
        });

        Scene scene = new Scene(parserStage, 800, 600);
        scene.setFill(Color.rgb(188, 129, 98));
        parserStage.setId("Color1");
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        primaryStage.setTitle("MLA Citation Generator.");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}