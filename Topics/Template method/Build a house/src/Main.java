import java.util.Scanner;

abstract class House {

    public abstract void placeFoundations();

    public abstract void placeWalls();

    public abstract void placeWindows();

    public abstract void placeDoors();

    // write your code here ...
    public abstract void build();



    // Do not change the code below
    public void chooseLocation() {
        System.out.println("Choose the best location for the new house");
    }

    public void placeRoofs() {
        System.out.println("Place metal sheet roofs");
    }

    public void connectElectricity() {
        System.out.println("Connect the house to the electrical grid");
    }
}

class Wooden extends House {
    @Override
    public void placeFoundations() {
        System.out.println("Place a wooden foundation");
    }

    @Override
    public void placeWalls() {
        System.out.println("Place wooden walls");
    }

    @Override
    public void placeWindows() {
        System.out.println("Place wooden windows");
    }

    @Override
    public void placeDoors() {
        System.out.println("Place wooden doors");
    }

    @Override
    public void build() {
        super.chooseLocation();
        placeFoundations();
        placeWalls();
        placeWindows();
        placeDoors();
        super.placeRoofs();
        super.connectElectricity();
    }
    // write your code here ...
}

// Do not change the code below
class Stone extends House {


    @Override
    public void placeFoundations() {
        System.out.println("Place a stone foundation");
    }

    @Override
    public void placeWalls() {
        System.out.println("Place stone walls");
    }

    @Override
    public void placeWindows() {
        System.out.println("Place reinforced windows");
    }

    @Override
    public void placeDoors() {
        System.out.println("Place reinforced doors");
    }

    @Override
    public void build() {
        super.chooseLocation();
        placeFoundations();
        placeWalls();
        placeWindows();
        placeDoors();
        super.placeRoofs();
        super.connectElectricity();
    }
}

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.nextLine();
        scanner.close();
        House house = null;
        if ("wooden".equalsIgnoreCase(type)) {
            house = new Wooden();
        } else if ("stone".equalsIgnoreCase(type)) {
            house = new Stone();
        } else {
            System.out.println("Error!");
            System.exit(0);
        }
        house.build();
    }
}