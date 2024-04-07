import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private FileWriter output;
    private FileReader input;
    private savedField sField;
    private String readFile;
    private String writeFile;
    FileManager(){}
    FileManager(String File) {
        try {
            input = new FileReader(File);
            readFile = File;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void MapSaver(Field fld, String file){
        sField = new savedField(fld.getXsize(), fld.getYsize(), fld.getMap(), fld.getFines(), fld.getTer());
        FileOutputStream save;
        try {
            save = new FileOutputStream("d://labs_java/maps/" + file + ".ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectOutputStream objSave = new ObjectOutputStream(save);
            objSave.writeObject(sField);
            objSave.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setOutput(String File) {
        try {
            output = new FileWriter(File);
            writeFile = File;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void MapReader(Field fld) {
        fld = new Field(sField);
        System.out.println(fld);
    }
    public FileWriter getOutput() {
        return output;
    }
}
