import java.io.*;

public class FileManager {
    private savedField sField;
    FileManager(){}
    public void MapSaver(Field fld, String file){
        sField = new savedField(fld.getXsize(), fld.getYsize(), fld.getMap(), fld.getFines(), fld.getTer());
        FileOutputStream save;
        try {
            save = new FileOutputStream("d:/labs_java/maps/" + file + ".ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            ObjectOutputStream objSave = new ObjectOutputStream(save);
            objSave.writeObject(sField);
            objSave.close();
            save.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Field MapReader(String file) {
        FileInputStream load;
        try {
            load = new FileInputStream("d:/labs_java/maps/" + file + ".ser");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream objLoad;
        try {
            objLoad = new ObjectInputStream(load);
            sField = (savedField) objLoad.readObject();
            objLoad.close();
            load.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return new Field(sField);
    }
}
