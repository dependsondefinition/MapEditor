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
}
