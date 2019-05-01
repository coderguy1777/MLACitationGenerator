import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MLA {
    private String authorname;
    private int year;
    private String publishername;
    private String title;
    private String url;

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
                AuthorName.add(this.authorname.substring(space + 1, this.authorname.length()));
            }
        }
        mlaAuthor = AuthorName.get(1) + ", " + AuthorName.get(0) + "";
        return mlaAuthor;
    }

    public String generateMLATitle() {
        String mla = ("") + this.title;
        System.out.println(mla);
        return mla;
    }

    public String generateMLABookCitation() {
        String citationparta = "<!DOCTYPE html> \n" +
                "<html> \n" +
                "<head> \n" +
                    "<meta charset=utf-8> \n" +
                    "<title>Citations</title> \n" + 
                "</head> \n" + 
                "<body> \n" + 
                    "<p> ";
        
        String citationpartb = generateMLAName() + ", " + generateMLATitle() + ", " + this.publishername + ", " + this.year;
        String citationpartc = "</p> \n" + 
                            "</body> \n" + 
                            "</html>";
        return citationparta + citationpartb  + citationpartc;
    }

}