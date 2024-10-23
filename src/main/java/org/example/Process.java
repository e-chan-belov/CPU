package org.example;

public class Process
{
    public String com;
    public int[] reg;
    public Process(String a, int r1, int r2) {
        com = a;
        reg = new int[] {r1, r2};
    }
    public Process(String a, int r) {
        com = a;
        reg = new int[] {r, 0};
    }
    public Process(String a) {
        com = a;
        reg = new int[] {0, 0};
    }
    public String getName() {
        return com;
    }
}
