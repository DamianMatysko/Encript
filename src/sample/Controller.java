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


    File selectedFile = null;

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
        while (fileReader.hasNextLine()) {
            String data = fileReader.nextLine();
            System.out.println(data);
        }
    }
}