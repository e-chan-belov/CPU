package org.example;

import java.util.*;
import java.util.Map.Entry;

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

    public HashMap<String, Integer> statistic() {
        HashMap<String, Integer> temp = new HashMap<>();
        for (Process instruction : this) {
            String t = instruction.com;
            if (temp.containsKey(t)) {
                temp.put(t, temp.get(t) + 1);
            }
            else {
                temp.put(t, 1);
            }
        }
        return temp;
    }
    public ArrayList<Entry<String, Integer>> maxStatistic() {
        Comparator<Entry<String, Integer>> valueComparator = (e1, e2) -> {
            Integer v2 = e1.getValue();
            Integer v1 = e2.getValue();
            return v1.compareTo(v2);
        };
        ArrayList<Entry<String, Integer>> temp = new ArrayList<>(statistic().entrySet());
        temp.sort(valueComparator);
        return temp;
    }
    public String mostUsed() {
        return maxStatistic().get(0).getKey();
    }
    public int[] rangeOfMemory() {
        int mn = 2048, mx = 0, obj = 0;
        for (Process command : this) {
            if (Objects.equals(command.com, "LD")) {
                obj = command.reg[0];

            }
            else if (Objects.equals(command.com, "ST")) {
                obj = command.reg[1];
            }
            else {
                continue;
            }
            mn = Math.min(obj, mn);
            mx = Math.max(obj, mx);
        }
        return new int[] {mn, mx};
    }
}
