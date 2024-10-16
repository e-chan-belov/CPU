package org.example;

public class Executer {
    static public void run(Handle cpu, AlgoProg prog) {
        for (Process instruction : prog) {
            prog.setFlag(cpu.exec(instruction));
        }
    }
}
