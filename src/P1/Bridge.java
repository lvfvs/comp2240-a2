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
    private final int BRIDGE_LENGTH = 20; // A farmer takes 20 steps to cross the bridge
    private final Semaphore bridgeLock = new Semaphore(1, true); // A semaphore representing the bridge
    private int NEON = 0; // Tracks the number of farmers that have crossed the bridge

    public void use(Farmer farmer) {
        while(true) {
            try {
                System.out.println(farmer.getId() + ": Waiting for bridge. Going towards " + farmer.getDestination());
                bridgeLock.acquire();

                if(NEON >= 100) {
                    break;
                }

                for(int i = 0; i <= BRIDGE_LENGTH; i++) {
                    farmer.incrementStep();

                    if(i == BRIDGE_LENGTH) {
                        System.out.println(farmer.getId() + ": Across the bridge.");

                    }

                    else if(i % 5 == 0){
                        System.out.println(farmer.getId() + ": Crossing bridge Step " + i + ".");
                        Thread.sleep(20);
                    }
                }
            }

            catch(InterruptedException e) {
                e.printStackTrace();
            }

            this.NEON++;
            System.out.println("NEON = " + NEON);
            bridgeLock.release();
            farmer.setDestination();

        }

    }


    /**
     * getBridgeLength method
     * @return int value of the bridge length
     */
    public int getBridgeLength() {
        return this.BRIDGE_LENGTH;
    }

    /**
     * getNeon method
     * @return int value of the amount of times that farmers have crossed the bridge
     */
    public int getNeon() {
        return this.NEON;
    }

    /**
     * setNeon method
     * @param NEON
     */
    public void setNeon(int NEON) {
        this.NEON = NEON;
    }

    /**
     * incrementNeon method
     * Increments the NEON count
     */
    public void incrementNeon() {
        this.NEON++;
    }
}
