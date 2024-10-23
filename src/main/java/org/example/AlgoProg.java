package org.example;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AlgoProg implements Iterable<Process> {
    ArrayList<Process> list;
    int flag = 1;
    public AlgoProg(Process[] _list) {
        list = new ArrayList<>();
        list.addAll(Arrays.asList(_list));
    }
    public AlgoProg() {
        list = new ArrayList<>();
    }

    public int add(Process command) {
        list.add(command);
        return list.size() - 1;
    }
    public Process pop() {
        return list.remove(list.size() - 1);
    }
    public Process pop(int index) {
        return list.remove(index);
    }
    public Process change(int index, Process command) {
        return list.set(index, command);
    }

    public void setFlag(int a) {
        flag = a;
    }
    public int len() {
        return list.size();
    }
    @Override
    public Iterator<Process> iterator() {
        return new Iterator<Process>() {
            int IP = 0;
            @Override
            public boolean hasNext() {
                if (IP < list.size()) {
                    return true;
                }
                else {
                    flag = 1;
                    return false;
                }
            }
            @Override
            public Process next() {
                return list.get((IP += flag) - flag);
            }
        };
    }

    public Map<String, Long> statistic() {
        return list.stream().collect(Collectors.groupingBy(Process::getName, Collectors.counting()));
    }
    public ArrayList<Entry<String, Long>> maxStatistic() {
        Comparator<Entry<String, Long>> valueComparator = (e1, e2) -> {
            Long v2 = e1.getValue();
            Long v1 = e2.getValue();
            return v1.compareTo(v2);
        };
        ArrayList<Entry<String, Long>> temp = new ArrayList<>(statistic().entrySet());
        temp.sort(valueComparator);
        return temp;
    }
    public String mostUsed() {
        return maxStatistic().get(0).getKey();
    }
    public int[] rangeOfMemory() {
        int mn = 2048, mx = 0;
        Comparator<Entry<String, Long>> valueComparator = (e1, e2) -> {
            Long v2 = e1.getValue();
            Long v1 = e2.getValue();
            return v1.compareTo(v2);
        };
        List<Process> memCommands = list.stream().filter(
                command->command.getName().equals("LD") || command.getName().equals("ST")
        ).toList();
        List<Entry<String, Integer>> mem = memCommands.stream().collect(
                ()->new ArrayList<Entry<String, Integer>>(),
                (list_, item) -> list_.add((item), // doesn't work


        }));

        mx = mem.stream().max((v1, v2)->Integer.compare(v1.getValue(), v2.getValue())).get().getValue();

        mn = mem.stream().min((v1, v2)->Integer.compare(v1.getValue(), v2.getValue())).get().getValue();
        return new int[] {mn, mx};
    }
}
