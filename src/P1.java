/*
 *
 *  File: P1.java
 *  Assignment: Assignment 2
 *  Course: COMP2240, Operating Systems
 *  Author: Olivia Favos
 *  Student Number: c3188124
 *  Description: 
 */

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;

import P1.Bridge;
import P1.Farmer;

public class P1 {
    public static void main(String[] args) {
        try {
            if(args.length != 1) {
                System.out.println("Error: File not found!");
                return;
            }

            File file = new File(args[0]);

            P1 p1 = new P1();
            p1.run(file);
        }

        catch(FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void run(File file) throws FileNotFoundException {
        int[] values = getValues(file);
        Bridge bridge = new Bridge();
        ArrayList<Farmer> farmers = spawnFarmers(values[0], values[1], bridge);

        // Generate farmer threads
        for(Farmer farmer : farmers) {
            new Thread(farmer).start();
        }
    }

    private int[] getValues(File file) throws FileNotFoundException {
        Scanner input = new Scanner(file);
        String[] values = input.nextLine().split(",\\s");
        int[] array = new int[2];

        if (values[0].startsWith("N")) {
            int north = Integer.parseInt(values[0].substring(2));
            int south = Integer.parseInt(values[1].substring(2));
            array[0] = north;
            array[1] = south;
        }

        return array;
    }

    private ArrayList<Farmer> spawnFarmers(int north, int south, Bridge bridge) {
        ArrayList<Farmer> farmers = new ArrayList<>();

        for(int i = 0; i < north; i++) {
            farmers.add(new Farmer("N_Farmer" + (i + 1), "North", bridge));
        }

        for(int i = 0; i < south; i++) {
            farmers.add(new Farmer("S_Farmer" + (i + 1), "South", bridge));
        }

        return farmers;
    }
}

