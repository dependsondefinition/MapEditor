package Logic;

import java.io.Serializable;

public class Cell implements Serializable {
    private static final long serialVersionUID = 1L;
    private String typeOfTerrain;
    Cell(String input)
    {
        typeOfTerrain = input;
    }
    public void setTerrain(String terrain)
    {
        this.typeOfTerrain = terrain;
    }
    public String getTer()
    {
        return this.typeOfTerrain;
    }
}
