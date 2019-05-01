import java.util.*;
import java.io.*;
import javafx.*;

public class MLAWeb extends MLA {
    MLA citationa;
    public final static String citationparta = "<!DOCTYPE html> \n" +
            "<html> \n" +
            "<head> \n" +
            "<meta charset=utf-8> \n" +
            "<title>Citations</title> \n" +
            "</head> \n" +
            "<body> \n" +
            "<p>";
    public final static String citationpartc = "</p> \n" +
            "</body> \n" +
            "</html>";
    String indents = "&nbsp&nbsp&nbsp&nbsp";

    public MLAWeb(MLA citationa) {
        super(citationa.year, citationa.title, citationa.publishername, citationa.authorname, citationa.url);
    }

    public void generateWebCitation() {
        String webcitation = "\"" + citationa.url + "." + " \"";
    }
}