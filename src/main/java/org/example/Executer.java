package org.example;

import java.util.Iterator;

public class Executer {
    static public void run(Handle cpu, AlgoProg prog) {
        Iterator<Process> iter = prog.iterator();
        while (iter.hasNext()) {
            prog.setFlag(cpu.exec(iter.next()));
        }
    }
}
