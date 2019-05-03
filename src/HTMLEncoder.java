import java.util.*;
import java.io.*;

public class HTMLEncoder {
    public String doctag() {
        return "<!DOCTYPE html>\n";
    }

    public String htmltag() {
        return "<html>\n";
    }

    public String headtag() {
        return "<head>\n";
    }

    public String metatag() {
        return "<meta charset=\"utf-8\">\n";
    }

    public String titletag() {
        return "<title>Citations made:</title>\n";
    }

    public String endhead() {
        return "</head>\n";
    }

    public String bodytag() {
        return "<body>\n";
    }

    public String ptag() {
        return "<p>";
    }

    public String endptag() {
        return "</p>";
    }

    public String addspace() {
        return "  ";
    }

    public String italicize(String wantedText) {
        return "<i>" + wantedText + "</i>";
    }

    public String endbody() {
        return "</body>\n";
    }

    public String endhtml() {
        return "</html>";
    }

}