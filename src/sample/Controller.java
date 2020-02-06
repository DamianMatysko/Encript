package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public Button encript;
    public Button decript;
    public TextField key;
    public Button fileChooser;


    File selectedFile;
    String data = "";
    String newData = "";
    String keyString = "";

    public void selectFile(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File("C:\\Users\\Firefly"));
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TXT Files", "*.txt"));
        selectedFile = fc.showOpenDialog(null);

        if (selectedFile != null) {

            System.out.println(selectedFile.getAbsolutePath());
        } else {
            System.out.println("File is not valid!");
        }
    }

    public void dercrypt(ActionEvent actionEvent) {

    }

    public void encrypt(ActionEvent actionEvent) throws IOException {
        Scanner fileReader = new Scanner(selectedFile);
        char character;
        int ascicode;


        keyString = key.getText();
        //keyString="abc";
        char keyAsciChar;
        int keyAsciInt;
        while (fileReader.hasNextLine()) {
            data = fileReader.nextLine();
            System.out.println(data);
        }
        int j=0;
        for (int i = 0; i < data.length(); i++) {
            character = data.charAt(i);
            ascicode = character;
            if (ascicode >= 65 && ascicode <= 90 || ascicode >= 97 && ascicode <= 122) {
                //j++;
                if (keyString.length()==j){
                    //j-=keyString.length();
                    j=0;
                }
                //pories System.out.println(j);
                keyAsciChar=keyString.charAt(j);
                keyAsciInt=keyAsciChar;//int
                keyAsciInt=keyAsciInt-96;

                ascicode = keyAsciInt+ascicode;
                System.out.println(keyAsciInt);

                if (ascicode > 90 && ascicode < 97 || ascicode > 122) {
                    ascicode -= 26;//divne
                }
                character = (char) ascicode;
                j++;
            }
            newData += character;
        }
        System.out.println(newData);

    }
}