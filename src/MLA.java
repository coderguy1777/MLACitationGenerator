import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MLA {
    public String authorname;
    public int year;
    public String publishername;
    public String title;
    public String url;

    public MLA(int year, String title, String publishername, String authorname, String url) {
        this.year = year;
        this.title = title;
        this.publishername = publishername;
        this.authorname = authorname;
        this.url = url;
    }

    public String generateMLAName() {
        String mlaAuthor = "";
        int space = 0;
        ArrayList<String>AuthorName = new ArrayList<>();

        for(int i = 0; i < this.authorname.length(); i++) {
            if(this.authorname.charAt(i) == ' ') {
                space = i;
                AuthorName.add(this.authorname.substring(0, space));
                AuthorName.add("" + this.authorname.substring(space + 1, this.authorname.length()));
            }
        }
        mlaAuthor = this.authorname.substring(space + 1, this.authorname.length()) + ", " + this.authorname.substring(0, space);
        return mlaAuthor;
    }

    public String generateMLATitle() {
        return ("") + this.title;
    }

    public String generateMLABookCitation() {
        // local variables for citation method.
        ArrayList<String>Citation = new ArrayList<>();
        String citedBookMla = "";
        String indent = null;

        // Citation parts
        String citationparta = "<!DOCTYPE html> \n" + "<html> \n" + "<head> \n" + "<meta charset=utf-8> \n" + "<title>Citations</title> \n" + "</head> \n" + "<body> \n" + "<p>";
        String citationpartb = generateMLAName() + ". " + "\"<i>" + generateMLATitle() + "</i>\"" + ". " + this.publishername + ", " + this.year + ".";
        String temp = citationpartb;
        if(citationpartb.length() >= 100) {
            indent = citationpartb.substring(80, citationpartb.length() - 1);
            citationpartb = temp.substring(0, 80)  + "<br>" + "&nbsp&nbsp&nbsp&nbsp" + indent;
        } else {
            indent = indent;
            citationpartb = temp;
        }

        String citationpartc = "</p> \n" + "</body> \n" + "</html>";

        // makes citation for the book
        Citation.add(citationparta);
        Citation.add(citationpartb);
        Citation.add(citationpartc);
        for(String i: Citation) {
            citedBookMla += i + " ";
        }
        return citedBookMla;
    }

    public String mlaURL() {
        return "<i>" + this.url + "</i>";
    }

    public String generateWebCitation() {
        ArrayList<String>WebCitation = new ArrayList<>();
        String citedSiteMLA = "";
        String temp = "";
        String indent = null;
        String citationparta = "<!DOCTYPE html> \n" + "<html> \n" + "<head> \n" + "<meta charset=utf-8> \n" + "<title>Citations</title> \n" + "</head> \n" + "<body> \n" + "<p>";
        String citationb = "<p>" + generateMLAName() + "." + "\"" + generateMLATitle() + "." + "\"" + ", " + this.publishername + ", " + this.year + ", " + this.url;
        String citationpartc = "</p> \n" + "</body> \n" + "</html>";

        temp = citationb;
        if(citationpartb.length() >= 100) {
            indent = citationpartb.substring(80, citationpartb.length() - 1);
            citationb = temp.substring(0, 80)  + "<br>" + "&nbsp&nbsp&nbsp&nbsp" + indent;
        } else {
            indent = indent;
            citationb = temp;
        }
        WebCitation.add(citationparta);
        WebCitation.add(citationb);
        WebCitation.add(citationpartc);
        for(String cite: WebCitation) {
            citedSiteMLA += cite + " ";
        }
        return citedSiteMLA;

    }
}