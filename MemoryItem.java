package com.example.test;

public class MemoryItem {
    private String time;
    private int temperature;

    public MemoryItem(String time, int temperature) {
        this.time = time;
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public int getTemperature() {
        return temperature;
    }
}
