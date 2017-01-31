package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by David on 1/30/2017.
 */
public class WebsiteGenerator {

    public void createWebsite(boolean js, boolean css,
                              String name, String author){
        try  {
            new File("Data\\" + name ).mkdir();
            File f = new File("Data\\" +
                    name + "\\site.zip");
            if(js)
                new File("Data\\" + name + "\\js").mkdir();
            if(css)
                new File("Data\\" +name + "\\css").mkdir();
            ZipOutputStream out = new ZipOutputStream
                    (new FileOutputStream(f));

            ZipEntry e = new ZipEntry
                    ("index.html");
            out.putNextEntry(e);
        File file = new File("Data\\" + name + "\\index.html");
        File g = new File("Data\\" + name + "\\index2.html");
        PrintWriter pw1 = new PrintWriter(new FileWriter(g, true));
        PrintWriter pw = new PrintWriter(new FileWriter(f, true));
        pw.print("<html><head><meta name=\"author\" content=\"" + author + "\\><title></title></head><body></body></html>");
        pw1.print("<html><head><meta name=\"author\" content=\"" + author + "\\><title></title></head><body></body></html>");
        pw.close();
        pw1.close();
        }catch (FileNotFoundException ff){
            ff.printStackTrace();
        }
        catch (IOException fff){
            fff.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new WebsiteGenerator().createWebsite(true, true, "Billco","David");

    }
}
