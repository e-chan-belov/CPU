package org.example;

public class Factory {
    static public Handle build() {
        return new CPU2();
    }
}
