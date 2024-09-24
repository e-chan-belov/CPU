package org.example;

public class CPU implements Handle {
    protected Mem bus;
    public CPU(Mem _bus) {
        bus = _bus;
    }
    private int print() {
        System.out.printf("%d %d %d %d\n", bus.reg[0], bus.reg[1], bus.reg[2], bus.reg[3]);
        return 1;
    }
    private int ld(int m, int r) {
        bus.reg[r] = bus.memory[m];
        return 1;
    }
    private int st(int r, int m) {
        bus.memory[m] = bus.reg[r];
        return 1;
    }
    private int init(int r, int a) {
        bus.reg[r] = a;
        return 1;
    }
    private int mv(int r1, int r2) {
        bus.reg[r2] = bus.reg[r1];
        return 1;
    }
    private int add() {
        bus.reg[3] = bus.reg[0] + bus.reg[1];
        return 1;
    }
    private int sub() {
        bus.reg[3] = bus.reg[0] - bus.reg[1];
        return 1;
    }
    private int mul() {
        return 1;
    }
    public int exec(Process command) {
        switch(command.com) {
            case "LD":
                return ld(command.reg[0], command.reg[1]);
            case "ST":
                return st(command.reg[0], command.reg[1]);
            case "INIT":
                return init(command.reg[0], command.reg[1]);
            case "MOVE":
                return mv(command.reg[0], command.reg[1]);
            case "ADD":
                return add();
            case "SUB":
                return sub();
            case "MUL":
                return mul();
            case "SHOW":
                return print();
            default:
                return 1;
        }
    }


}

