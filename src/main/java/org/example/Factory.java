package org.example;

public class Factory {
    static public Handle build() {
        Mem bus = new Mem();
        return new CPU2(bus);
    }
}
