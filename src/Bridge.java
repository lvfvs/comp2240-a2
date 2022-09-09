/*
 *
 *  File: Bridge.java
 *  Assignment: Assignment 2
 *  Course: COMP2240, Operating Systems
 *  Author: Olivia Favos
 *  Student Number: c3188124
 *
 */

import java.util.concurrent.*;
public class Bridge {
    private final int BRIDGE_LENGTH = 20; // A farmer takes 20 steps to cross the bridge
    private final Semaphore bridgeLock = new Semaphore(1, true); // A semaphore representing the bridge
    private int neon = 0; // Tracks the number of farmers that have crossed the bridge


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
        return this.neon;
    }

    /**
     * setNeon method
     * @param neon
     */
    public void setNeon(int neon) {
        this.neon = neon;
    }

    /**
     * incrementNeon method
     * Increments the neon count
     */
    public void incrementNeon() {
        this.neon++;
    }
}
