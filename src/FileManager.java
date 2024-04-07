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
        try {
            fld = new Field();
            char ch = (char) input.read();
            int i = 0, j = 0;
            fld.getMap().add(i, new ArrayList<>());
            while(input.ready())
            {
                if(ch == '\n')
                {
                    i++;
                    j = 0;
                    fld.getMap().add(i, new ArrayList<>());
                }
                else
                {
                    fld.getMap().get(i).add(j, new Cell(String.valueOf(ch)));
                    j++;
                }
                ch = (char) input.read();
            }
            input.close();
            fld.setSize(i, j);
            System.out.println(fld);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public FileWriter getOutput() {
        return output;
    }
}
