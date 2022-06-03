package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;

public class Main {

    String solution(String[] operations) {
        StringBuilder sb = new StringBuilder();
        int cursor = 0, selectedSt = 0, selectedEd = 0;
        boolean selected = false;
        List<String> copyBoard = new LinkedList<>();
        for (String op : operations) {
            if (op.startsWith("TYPE")) {
                String text = op.substring(5);
                if (!selected) {
                    sb.insert(cursor, text);
                    cursor += text.length();
                }
                else {
                    sb.replace(selectedSt, selectedEd + 1, text);
                    cursor = selectedSt + text.length();
                }
                selected = false;
            } else if (op.startsWith("SELECT")) {
                String[] parts = op.split(" ");
                selectedSt = Integer.parseInt(parts[1]);
                selectedEd = Integer.parseInt(parts[2]);
                cursor = selectedEd + 1;
                selected = true;
            } else if (op.startsWith("COPY")) {
                if (selected) {
                    copyBoard.add(sb.substring(selectedSt, selectedEd + 1));
                    System.out.println("copy board add " + sb.substring(selectedSt, selectedEd + 1));
                }
            } else if (op.startsWith("PASTE")) {
                String[] parts = op.split(" ");
                int steps_back = 1;
                if (parts.length > 1)
                    steps_back = Integer.parseInt(parts[1]);
                ListIterator<String> iter = copyBoard.listIterator(copyBoard.size());
                String copyText = null;
                for (int i = 0; i < steps_back; i++) {
                    copyText = iter.previous();
                }
                iter.remove();
                if (selected) {
                    sb.replace(selectedSt, selectedEd + 1, copyText);
                    cursor = selectedSt + copyText.length();
                } else {
                    sb.insert(cursor, copyText);
                    cursor += copyText.length();
                }
                selected = false;
            } else if (op.startsWith("MOVE_CURSOR")) {
                String[] parts = op.split(" ");
                int move = Integer.parseInt(parts[1]);
                cursor += move;
                selected = false;
                cursor = cursor >= 0 ? cursor : 0;
                cursor = cursor < sb.length() ? cursor : sb.length() - 1;
            }
            System.out.println("string = " + sb.toString() + ", cursor = " + cursor);
        }
        return sb.toString();
    }

    public void work() {
        String[] operations = {
                "TYPE My dog",
                "SELECT 3 4",
                "MOVE_CURSOR -1",
                "TYPE ial",
                "SELECT 0 1",
                "TYPE His"
        };
        System.out.println(solution(operations));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
