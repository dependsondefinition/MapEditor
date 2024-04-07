import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class savedField implements Serializable {
    private int xsize;
    private int ysize;
    private ArrayList<ArrayList<Cell>> Map;
    private HashMap<String, float[]> Fines;
    private List<String> ter;
    savedField(int xsize, int ysize, ArrayList<ArrayList<Cell>> Map, HashMap<String, float[]> Fines, List<String> ter) {
        this.xsize = xsize;
        this.ysize = ysize;
        this.Map = Map;
        this.Fines = Fines;
        this.ter = ter;
    }
    public int getXsize() {
        return xsize;
    }
    public int getYsize() {
        return ysize;
    }
    public ArrayList<ArrayList<Cell>> getMap() {
        return Map;
    }
    public HashMap<String, float[]> getFines() {
        return Fines;
    }
    public List<String> getTer() {
        return ter;
    }
}
