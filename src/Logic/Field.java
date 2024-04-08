package Logic;

import Logic.Cell;

import java.util.*;

public class Field {
    private int xsize;
    private int ysize;
    private ArrayList<ArrayList<Cell>> Map = new ArrayList<>();
    private HashMap<String, float[]> Fines = new HashMap<>();
    private ArrayList<String> ter =  new ArrayList<>(Arrays.asList("*", "!", "#", "@", "^"));
    public Field(int x, int y)
    {
        xsize = x;
        ysize = y;
        Fines.put(ter.get(0), new float[]{1f, 1f, 1f});
        Fines.put(ter.get(1), new float[]{1.2f, 1f, 1.5f});
        Fines.put(ter.get(2), new float[]{1.5f, 1.8f, 2.2f});
        Fines.put(ter.get(3), new float[]{2f, 2.2f, 1.2f});
        Fines.put(ter.get(4), new float[]{2.5f, 3.5f, 3f});
        creation();
    }
    public Field(savedField sField)
    {
        this.xsize = sField.getXsize();
        this.ysize = sField.getYsize();
        this.Map = sField.getMap();
        this.Fines = sField.getFines();
        this.ter = sField.getTer();
    }
    private void creation()
    {
        for(int i = 0; i < xsize; i++)
        {
            Map.add(i, new ArrayList<>());
            for(int j = 0; j < ysize; j++)
            {
                Map.get(i).add(j, new Cell(ter.getFirst()));
            }
        }
    }
    public void randomGen()
    {
        int terrain;
        for(int i = 0; i < xsize; i++)
        {
            int lim = ysize / 3;
            terrain = (int) (Math.random() * (ter.size() - 1)) + 1;
            for(int j = 0; j < ysize; j++)
            {
                if(i == 0 || i == xsize - 1 || lim == 0 || j == 0 || j == ysize - 1)
                {
                    Map.get(i).get(j).setTerrain(ter.getFirst());
                }
                else
                {
                    Map.get(i).get(j).setTerrain(ter.get(randTer(terrain)));
                    if(!Map.get(i).get(j - 1).getTer().equals("*") || !Map.get(i - 1).get(j).getTer().equals("*"))
                    {
                        Map.get(i).get(j).setTerrain(ter.getFirst());
                    }
                    else if (!Map.get(i).get(j).getTer().equals("*")){
                        lim--;
                    }
                }
            }
        }
    }
    private int randTer(int ter1)
    {
        if(Math.round(Math.random()) == 1)
        {
            return 0;
        }
        else
        {
            return ter1;
        }
    }
    @Override
    public String toString()
    {
        String fld = "";
        for(int i = 0; i < xsize; i++)
        {
            for(int j = 0; j < ysize; j++)
            {
                fld += Map.get(i).get(j).getTer();
            }
            fld += "\n";
        }
        return fld;
    }
    public void addTer(String obst){
        ter.add(obst);
    }
    public void addFines(float Mfine, float Sfine, float Hfine){
        Fines.put(ter.getLast(), new float[]{Mfine, Sfine, Hfine});
    }
    public ArrayList<ArrayList<Cell>> getMap() {
        return this.Map;
    }

    public HashMap<String, float[]> getFines() {
        return Fines;
    }

    public ArrayList<String> getTer()
    {
        return ter;
    }
    public int getXsize() {
        return xsize;
    }

    public int getYsize() {
        return ysize;
    }
}
