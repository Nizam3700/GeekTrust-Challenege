package org.example.Entity;

public class Bogie {
    private String destination;
    private int distance;

    public Bogie(String destination, int distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public String getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }
}