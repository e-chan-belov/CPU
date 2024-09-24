package org.example;

public class CPU2 extends CPU {
    public CPU2(Mem _bus) {
        super(_bus);
    }
    private int div() {
        bus.reg[3] = bus.reg[0] / bus.reg[1];
        return 1;
    }
    private int jump() {
        return bus.reg[0];
    }
    private int jumpeq() {
        if (bus.reg[0] == bus.reg[1]) {
            return bus.reg[2];
        }
        return 1;
    }
    private int nope() {
        return 1;
    }
    private int jumpgreq() {
        if (bus.reg[0] >= bus.reg[1]) {
            return bus.reg[2];
        }
        return 1;
    }
    private int inc(int r) {
        bus.reg[r] += 1;
        return 1;
    }
    private int mul() {
        bus.reg[3] = bus.reg[0] * bus.reg[1];
        return 1;
    }
    public int exec(Process command) {
        switch(command.com) {
            case "MUL":
                return mul();
            case "DIV":
                return div();
            case "JE":
                return jumpeq();
            case "JGE":
                return jumpgreq();
            case "NOPE":
                return nope();
            case "INC":
                return inc(command.reg[0]);
            case "JMP":
                return jump();
            default:
                return super.exec(command);
        }
    }
}
