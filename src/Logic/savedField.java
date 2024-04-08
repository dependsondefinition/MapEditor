package Logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class savedField implements Serializable {
    private static final long serialVersionUID = 1L;
    private int xsize;
    private int ysize;
    private ArrayList<ArrayList<Cell>> Map;
    private HashMap<String, float[]> Fines;
    private ArrayList<String> ter;
    public savedField(int xsize, int ysize, ArrayList<ArrayList<Cell>> Map, HashMap<String, float[]> Fines, ArrayList<String> ter) {
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
    public ArrayList<String> getTer() {
        return ter;
    }
}
