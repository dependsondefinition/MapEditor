import java.io.File;
import java.util.Scanner;

public class MapEditor {
    private Field field;
    private FileManager manager = new FileManager();
    private Scanner scan = new Scanner(System.in);
    private boolean trueIn = false;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE = "\u001B[34m";
    MapEditor() {
        System.out.println("Welcome to MapEditor");
        System.out.println("Choose action from list:");
        System.out.println("1. Create new map");
        System.out.println("2. Load from file");
        System.out.println("3. Delete map");
        while(!trueIn) {
            choice(scan.nextInt());
        }
    }
    public void mainLoop()
    {
        while(true)
        {
            System.out.println("1. Add new obstacle");
            System.out.println("2. Edit current map");
            System.out.println("3. Save to file");
            int num = scan.nextInt();
            if(num == 1) {
                newLand();
            }
            else if(num == 2) {
                edit();
            }
            else if(num == 3) {
                System.out.println("Enter the name of file (WITHOUT EXTENSION)");
                manager.MapSaver(field, scan.next());
                break;
            }
        }
    }
    private void choice(int input) {
        trueIn = true;
        if(input == 1)
        {
            System.out.println("Set size of field (x and y)");
            field = new Field(scan.nextInt(), scan.nextInt());
            System.out.println("Generate field randomly? (Y|N)");
            if(scan.next().equals("Y"))
            {
                field.randomGen();
            }
            System.out.println(field);
        }
        else if(input == 2)
        {
            System.out.println("Choose file to load from");
            field = manager.MapReader(scan.next());
            System.out.println(field);
        }
        else if(input == 3)
        {
            trueIn = false;
            System.out.println("Choose file to delete map");
            File delete = new File("d:/labs_java/maps/" + scan.next() + ".ser");
            if(delete.delete())
            {
                System.out.println("Map was successfully deleted");
            }
            else{
                System.out.println("Such map doesn't exits");
            }
        }
        else {
            trueIn = false;
            System.out.println("Wrong input!");
        }
    }
    private void newLand()
    {
        System.out.println("Type the symbol of the obstacle");
        String obst = scan.next();
        if(field.getTer().contains(obst)) {
            System.out.println("This obstacle is already exists");
        }
        else {
            field.addTer(obst);
            System.out.println("Enter the fines for Melee, Shooter and Horseman units");
            field.addFines(scan.nextFloat(), scan.nextFloat(), scan.nextFloat());
        }
    }
    private void edit()
    {
        int i = 0, j = field.getYsize() - 1, lim = 0;
        while(true)
        {
            if(j == field.getYsize() - 1 || lim == 0) {
                lim = 1 + field.getYsize() / 3;
                j = 1;
                i++;
                if(i == field.getXsize() - 1)
                {
                    break;
                }
            }
            Cell tCell = field.getMap().get(i).get(j);
            tCell.setTerrain(ANSI_BLUE + tCell.getTer() + ANSI_RESET);
            System.out.println(field);
            System.out.println("Do you want to change this terrain? (Y|N)");
            System.out.println("To skip this line type S, to end the edit type E");
            String answer = scan.next();
            if(lim > 0 && answer.equals("Y")) {
                System.out.println(field.getTer());
                tCell.setTerrain(scan.next());
                j++;
                if(!tCell.getTer().equals(field.getTer().getFirst())) {
                    lim--;
                }
            }
            else {
                tCell.setTerrain(tCell.getTer().substring(ANSI_BLUE.length(), tCell.getTer().length() - ANSI_RESET.length()));
                if(answer.equals("N")){
                    j++;
                }
                else if(answer.equals("S"))
                {
                    lim = 0;
                }
                else if(answer.equals("E"))
                {
                    break;
                }
            }
        }
    }
}
