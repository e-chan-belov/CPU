package org.example;

public class CPU2 extends CPU {
    public CPU2() {
        super();
    }
    private int div() {
        reg[3] = reg[0] / reg[1];
        return 1;
    }
    private int jump() {
        return reg[0];
    }
    private int jumpeq() {
        if (reg[0] == reg[1]) {
            return reg[2];
        }
        return 1;
    }
    private int nope() {
        return 1;
    }
    private int jumpgreq() {
        if (reg[0] >= reg[1]) {
            return reg[2];
        }
        return 1;
    }
    private int inc(int r) {
        reg[r] += 1;
        return 1;
    }
    private int mul() {
        reg[3] = reg[0] * reg[1];
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
