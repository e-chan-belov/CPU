package org.example;

public class Mem {
    public int[] reg;
    public int[] memory;
    public Mem() {
        reg = new int[] {0, 0, 0, 0};
        memory = new int[2048];
    }
}
