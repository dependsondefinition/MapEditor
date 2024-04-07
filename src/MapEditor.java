import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MapEditor {
    private Field field;
    private FileManager manager;
    private Scanner scan = new Scanner(System.in);
    private boolean trueIn = false;
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

            }
            else if(num == 3) {
                System.out.println("Enter the name of file (WITHOUT EXTENSION)");
                manager.setOutput("d:/labs_java/maps/" + scan.next() + ".txt");
                try {
                    manager.getOutput().write(field.toString());
                    manager.getOutput().close();
                    break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
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
            manager = new FileManager();
        }
        else if(input == 2)
        {
            System.out.println("Choose file to load from");
            manager = new FileManager("d:/labs_java/maps/" + scan.next() + ".txt");
            manager.MapReader(field);
        }
        else if(input == 3)
        {
            trueIn = false;
            System.out.println("Choose file to delete map");
            File delete = new File("d:/labs_java/maps/" + scan.next() + ".txt");
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
}
