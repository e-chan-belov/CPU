package org.example;

public class Executer {
    static public void run(Handle cpu, Process[] prog) {
        for (int i = 0; i < prog.length; ) {
            i += cpu.exec(prog[i]);
        }
    }
}
