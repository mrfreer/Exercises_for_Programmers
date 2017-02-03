package com.company;

import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.photos.*;
import com.flickr4java.flickr.places.PlacesInterface;
import com.flickr4java.flickr.tags.RelatedTagsList;
import com.flickr4java.flickr.tags.TagsInterface;
import com.flickr4java.flickr.test.TestInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by dfreer on 2/3/2017.
 */
public class FlickrPhotoSearch {
    static JFrame jFrame = new JFrame("Photo Search.");
    public static boolean hasClicked = false;
    PhotoUrl photoUrl2;
    private JTextField textFieldPhoto;
    private JButton searchButton;
    private JPanel flickrImages;
    private JPanel ID;
    private JTextField textField1;
    private JLabel picture;
    private JLabel jLabelTweets;
    private JPanel layout;
    String apiKey = "", sharedSecret = "";
    String getImageURL = "";
    public JPanel getMainPanel(){
        return ID;
    }

    public JTextField getTextField(){
        return textField1;
    }

    public FlickrPhotoSearch() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasClicked = true;
                try {
                    Scanner scan = new Scanner(new FileReader("" +
                            "C:\\Users\\dfreer\\Documents\\Programming\\FlickrAPI.txt"));
                    apiKey = scan.next();
                    sharedSecret = scan.next();
                    Flickr f = new Flickr(apiKey, sharedSecret, new REST());
                    TestInterface testInterface = f.getTestInterface();
                    PhotosInterface pi = f.getPhotosInterface();
                    PlacesInterface placesInterface =f.getPlacesInterface();
                    TagsInterface tagsInterface = f.getTagsInterface();
//                    RelatedTagsList related = tagsInterface.getRelated();
                    Collection photosCollection = tagsInterface.getRelated(textField1.getText());
                    SearchParameters searchParameters = new SearchParameters();
                    searchParameters.setTags(new String[]{textField1.getText()});
                    PhotoList<Photo> list = f.getPhotosInterface().search(searchParameters, 0, 0);
                    System.out.println(list.size());
                    if(list.size() == 0)
                        JOptionPane.showMessageDialog(null, "No images of "+
                        textField1.getText());
                    else {
                        System.out.println(list.get(0).getId() + " is the ID");
                        for (Photo curPhoto : list) {
                            if (curPhoto.isPublicFlag()) {
                                photoUrl2 = curPhoto.getPhotoUrl();
                                System.out.println(curPhoto.getMedium800Url());
                                getImageURL = curPhoto.getSmallUrl();
                                try {
                                    go();
                                } catch (Exception hh) {
                                    hh.printStackTrace();
                                }
                                ;
                                break;
                            }
                        }
                    }
                } catch (FileNotFoundException g) {
                    g.printStackTrace();
                }
                catch (FlickrException h) {
                    h.printStackTrace();
                }

            }

        });
            }


    public static void main(String[] args) {



            jFrame.setContentPane(new FlickrPhotoSearch().ID);
            jFrame.pack();
            jFrame.setVisible(true);

            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

    public void go() throws Exception{
        System.out.println(getImageURL + " what do we have here?");
        URL tryThis = new URL(getImageURL);
        BufferedImage image = ImageIO.read(tryThis);

        picture.setText(textField1.getText());
        picture.setIcon(new ImageIcon(image));
        picture.repaint();
        System.out.println(picture.getIcon() + " is the icon");
        System.out.println(picture.getHeight() + " is the height");
        System.out.println(picture.getWidth() + " is the width");

        picture.repaint();
        //ID.repaint();
        //jFrame.repaint();
    }

    private void createUIComponents() {


    }
}
