/*
 *
 *  File: P1.java
 *  Assignment: Assignment 2
 *  Course: COMP2240, Operating Systems
 *  Author: Olivia Favos
 *  Student Number: c3188124
 *
 */

import java.nio.file.Path;
import java.nio.file.Paths;

public class P1 {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Error: File not found!");
            return;
        }

        Path path = Paths.get(args[0]);

        P1 p1 = new P1();
        p1.run(path);
    }

    private void run(Path file) {

    }
}
