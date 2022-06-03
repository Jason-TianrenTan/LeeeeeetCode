package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {

    private enum OPERATIONS {
        CHANGE, UNDO
    };

    String plaidTextEditor(String[][] input) {
        Stack<String> state = new Stack<>(), discard = new Stack<>();
        Stack<OPERATIONS> history = new Stack<>();
        int selectedStart = -1, selectedEnd = -1;
        state.push("");

        Arrays.sort(input, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                String time1 = o1[0], time2 = o2[0];
                return time1.compareTo(time2);
            }
        });
        for (String[] operation : input) {
            String op = operation[1];
            StringBuilder sb = new StringBuilder(state.peek());
            System.out.println("Current state = " + sb.toString());
            if (op.equals("INSERT")) {
                if (selectedStart > 0) {
                    System.out.println(selectedStart + ", " + selectedEnd);
                    sb.replace(selectedStart, selectedEnd, operation[2]);
                } else {
                    sb.append(operation[2]);
                }
                state.push(sb.toString());
                history.push(OPERATIONS.CHANGE);
            } else if (op.equals("DELETE")) {
                if (selectedStart > 0)
                    sb.delete(selectedStart, selectedEnd);
                else {
                    if (sb.length() > 0)
                        sb.deleteCharAt(sb.length() - 1);
                }
                state.push(sb.toString());
                history.push(OPERATIONS.CHANGE);
            } else if (op.equals("UNDO")) {
                if (state.size() > 1) {//Need to keep the initial ""
                    discard.push(state.pop());
                    history.push(OPERATIONS.UNDO);
                }
            } else if (op.equals("REDO")) {
                if (!discard.isEmpty() && !history.isEmpty() && history.peek().equals(OPERATIONS.UNDO)) {
                    state.push(discard.pop());
                    history.pop();
                }
            } else if (op.equals("SELECT")) {
                int start = Integer.parseInt(operation[2]), end = Integer.parseInt(operation[3]);
                if (start >= 0) {
                    end = end > sb.length() ? sb.length() : end;
                    selectedStart = start;
                    selectedEnd = end;
                }
            }  else if (op.equals("BOLD")) {
                StringBuilder temp = new StringBuilder();
                temp.append(sb.substring(0, selectedStart));
                temp.append("*");
                temp.append(sb.substring(selectedStart, selectedEnd + 1));
                temp.append("*");
                temp.append(sb.substring(selectedEnd + 1, sb.length()));
                state.push(temp.toString());
                history.push(OPERATIONS.CHANGE);
            }

        }
        return state.pop();
    }

    public static void main(String[] args) {
        // write your code here
        String[][] input = {
                {"0","INSERT","Hello"},
                {"1","SELECT","1","3"},
                {"2","BOLD"},
                {"3", "UNDO"}
        };
        System.out.println(new Main().plaidTextEditor(input));
    }
}
