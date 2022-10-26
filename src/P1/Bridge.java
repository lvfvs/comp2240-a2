/*
 *
 *  File: Bridge.java
 *  Assignment: Assignment 2
 *  Course: COMP2240, Operating Systems
 *  Author: Olivia Favos
 *  Student Number: c3188124
 *
 */

package P1;

import java.util.concurrent.*;
public class Bridge {
    private final Semaphore bridgeLock = new Semaphore(1, true); // A semaphore representing the bridge
    private int NEON = 0; // Tracks the number of farmers that have crossed the bridge

    public void use(Farmer farmer) {
        while (NEON < 100) {
            try {
                farmer.setDestination();
                System.out.println(farmer.getId() + ": Waiting for bridge. Going towards " + farmer.getDestination());
                bridgeLock.acquire();

                if(NEON >= 100) {
                    bridgeLock.release();
                    break;
                }
                int BRIDGE_LENGTH = 20;
                for (int i = 5; i <= BRIDGE_LENGTH; i++) {
                    farmer.incrementStep();

                    if (i == BRIDGE_LENGTH) {
                        this.NEON++;
                        farmer.setDestination();
                        bridgeLock.release();
                        System.out.println(farmer.getId() + ": Across the bridge.");
                        System.out.println("NEON = " + NEON);

                    } else if (i % 5 == 0) {
                        System.out.println(farmer.getId() + ": Crossing bridge Step " + i + ".");
                        Thread.sleep(20);
                    }
                }
            }

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
