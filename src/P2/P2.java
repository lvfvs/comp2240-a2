package P2;

import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class P2 {
    public static void main(String[] args) {
        try {
            if(args.length != 1) {
                System.out.println("Error: File not found!");
                return;
            }

            File file = new File(args[0]);

            P2 p2 = new P2();
            p2.run(file);
        }

        catch(FileNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void run(File file) throws FileNotFoundException {
        Parlour parlour = new Parlour();
        ArrayList<Customer> customers = generateCustomers(file, parlour);
        parlour.run(customers);
    }

    private ArrayList<Customer> generateCustomers(File file, Parlour parlour) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        ArrayList<Customer> customers = new ArrayList<>();

        while(input.hasNext()) {
            String[] values = input.nextLine().split("\\s");

            if(!values[0].equals("END")) {
                int arrivalTime = Integer.parseInt(values[0]);
                String id = values[1];
                int iceCreamEatingTime = Integer.parseInt(values[2]);

                customers.add(new Customer(id, arrivalTime, iceCreamEatingTime, parlour));

            }
        }

        return customers;
    }
}

/*

        private void run(File file) throws FileNotFoundException {
            int[] values = getValues(file);
            Bridge bridge = new Bridge();
            ArrayList<Farmer> farmers = spawnFarmers(values[0], values[1], bridge);

            // Generate farmer threads
            for(Farmer farmer : farmers) {
                new Thread(farmer).start();
            }

            Path path = Paths.get(args[0]);
        }

        private int[] getValues(File file) throws FileNotFoundException {
            Scanner input = new Scanner(file);
            String[] values = input.nextLine().split(",\\s");
            int[] array = new int[2];

            P1 p1 = new P1();
            p1.run(path);
            if (values[0].startsWith("N")) {
                int north = Integer.parseInt(values[0].substring(2));
                int south = Integer.parseInt(values[1].substring(2));
                array[0] = north;
                array[1] = south;
            }

            return array;
        }

        private void run(Path file) {
            private ArrayList<Farmer> spawnFarmers(int north, int south, Bridge bridge) {
                ArrayList<Farmer> farmers = new ArrayList<>();

                for(int i = 0; i < north; i++) {
                    farmers.add(new Farmer("N_Farmer", "North", bridge));
                }

                for(int i = 0; i < south; i++) {
                    farmers.add(new Farmer("S_Farmer", "South", bridge));
                }

                return farmers;
            }
        }*/