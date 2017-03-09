package filemanager;

import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.Shape;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cj on 2017-03-09.
 */
public class FileManager {

   static public List<Shape> loadFile(Stage primaryStage){
        File file = new FileChooser().showOpenDialog(primaryStage);
        try{
            return loadFile(file);
        }catch(IOException e){
            e.printStackTrace();
            showAlertLoadFile();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
   }


    static public void saveFile(Stage primaryStage, List<Shape> shapes){
        File file = new FileChooser().showSaveDialog(primaryStage);
        if (file != null) {
            try {
                saveFile(file, shapes);
            } catch (IOException e){
                e.printStackTrace();
                showAlertSaveFile();
            }
        }
    }
    static public void showAlertLoadFile(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Could not open file!");
        alert.setHeaderText("Could not open file!");
        alert.setContentText(null);
        alert.showAndWait();
    }
    static public void showAlertSaveFile(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Could not saved file");
        alert.setHeaderText("COULD NOT SAVE FILE \n\n please try again");
        alert.setContentText(null);
        alert.showAndWait();
    }

    static public List<Shape> loadFile(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream input;
        List<Shape> result = null;
        if (file != null) {
            System.out.println("FILE IS NOT NULL");
            input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            result = (List<Shape>) input.readObject();
            input.close();
        }
        return result;
    }
    static public void saveFile(File file, List<Shape> shapes) throws IOException{
        ObjectOutputStream output;
        if (file != null){
            output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            output.writeObject(shapes);
            output.close();
        }
    }
}
