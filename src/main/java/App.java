import org.example.Process;
import org.example.Handle;
import org.example.Factory;
import org.example.Executer;

public class App 
{
    public static void main( String[] args )
    {
        Handle a = Factory.build();
        Process[] test = {
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
        new Process("INIT", 2, 10),
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
        new Process("INIT", 0, -12),
        new Process("JMP"),
        new Process("LD", 2, 0),
        new Process("LD", 1, 1),
        new Process("LD", 0, 2),
        new Process("SHOW")};

        Executer.run(a, pow);
    }
}
