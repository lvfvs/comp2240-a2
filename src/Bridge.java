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
    private final int BRIDGE_LENGTH = 20; // A farmer takes 20 steps to cross the bridge.
    private final Semaphore bridge = new Semaphore(1);
    private int neon = 0; // Tracks the number of farmers that have crossed the bridge.


    public int getBridgeLength() {
        return this.BRIDGE_LENGTH;
    }

    public int getNeon() {
        return this.neon;
    }

    public void setNeon(int neon) {
        this.neon = neon;
    }

    public void incrementNeon() {
        this.neon++;
    }
}
