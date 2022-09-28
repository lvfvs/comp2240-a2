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