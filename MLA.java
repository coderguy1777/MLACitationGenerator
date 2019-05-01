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
        mlaAuthor = AuthorName.get(1) + ", " + AuthorName.get(0);

        System.out.println(mlaAuthor);
        return mlaAuthor;
    }

    private static void writeUsingFileWriter(String data) {
        File file = new File("C:/Users/lolzk/FileWriter.html");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
            Desktop.getDesktop().browse(file.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}