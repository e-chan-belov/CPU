package org.example;

public abstract class CPU implements Handle {
    protected int[] reg;
    protected int[] memory;
    public CPU() {
        reg = new int[] {0, 0, 0, 0};
        memory = new int[2048];
    }
    private int print() {
        System.out.printf("%d %d %d %d\n", reg[0], reg[1], reg[2], reg[3]);
        return 1;
    }
    private int ld(int m, int r) {
        reg[r] = memory[m];
        return 1;
    }
    private int st(int r, int m) {
        memory[m] = reg[r];
        return 1;
    }
    private int init(int r, int a) {
        reg[r] = a;
        return 1;
    }
    private int mv(int r1, int r2) {
        reg[r2] = reg[r1];
        return 1;
    }
    private int add() {
        reg[3] = reg[0] + reg[1];
        return 1;
    }
    private int sub() {
        reg[3] = reg[0] - reg[1];
        return 1;
    }
    private int mul() {return 1;}
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

