import org.example.*;
import org.example.Process;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
        Handle a = Factory.build();
        Process[] test1 = {
        new Process("INIT", 0, 1),
        new Process("INIT", 1, 2),
        new Process("ADD"),
        new Process("SHOW"), new Process("MOVE", 3, 2),
        new Process("MOVE", 3, 0),
        new Process("MUL"),
        new Process("SHOW"),
        new Process("MOVE", 3, 0),
        new Process("MOVE", 2, 1),
        new Process("DIV"),
        new Process("SHOW")};
        AlgoProg test = new AlgoProg(test1);
        Executer.run(a, test);

        int num = 5;
        int power = 6;
        Process[] pow = {
        new Process("INIT", 0, num),
        new Process("INIT", 1, power),
        new Process("INIT", 3, 1),
        new Process("ST", 0, 0),
        new Process("ST", 1, 1),
        new Process("ST", 3, 3),
        new Process("ST", 0, 2),
        new Process("INIT", 2, 9), // относительный адрес считается со следующей команды от джампа
        new Process("LD", 3, 0),
        new Process("LD", 1, 1),
        new Process("JGE"),
        new Process("LD", 0, 0),
        new Process("LD", 2, 1),
        new Process("MUL"),
        new Process("ST", 3, 0),
        new Process("LD", 3, 0),
        new Process("INC", 0),
        new Process("ST", 0, 3),
        new Process("INIT", 0, -13),
        new Process("JMP"),
        new Process("LD", 2, 0),
        new Process("LD", 1, 1),
        new Process("LD", 0, 2),
        new Process("SHOW")};
        AlgoProg power_prog = new AlgoProg(pow);
        Executer.run(a, power_prog);

        power_prog.statistic().forEach((key, value) -> System.out.println(key + " " + value + " " + (float) value / power_prog.len()));
        System.out.println(power_prog.maxStatistic());
        System.out.println(Arrays.toString(power_prog.rangeOfMemory()));
        System.out.println(power_prog.mostUsed());
    }
}
