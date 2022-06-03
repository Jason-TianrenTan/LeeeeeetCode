package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class Main {

    public class Element {
        boolean isParen = false;
        String name;
        int count;

        public Element(String str, int cnt) {
            this.name = str;
            this.count = cnt;
        }

        public Element() {
            isParen = true;
        }
    }

    boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }

    boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public String countOfAtoms(String formula) {
        TreeMap<String, Integer> ElementMap = new TreeMap<>();
        Stack<Element> elementStack = new Stack<>();
        char[] ch = formula.toCharArray();
        int pt = 0;
        while (pt < ch.length) {
            if (isUpperCase(ch[pt])) {
                StringBuilder sb = new StringBuilder();
                sb.append(ch[pt++]);
                while (pt < ch.length && isLowerCase(ch[pt]))
                    sb.append(ch[pt++]);
                String name = sb.toString();
                int count = 0;
                while (pt < ch.length && isNumeric(ch[pt]))
                    count = count * 10 + (ch[pt++] - '0');
                if (count == 0)
                    count = 1;
                elementStack.push(new Element(name, count));
            } else if (ch[pt] == '(') {
                elementStack.push(new Element());
                pt++;
            } else if (ch[pt] == ')') {
                int outer_count = 0;
                List<Element> elementList = new ArrayList<>();
                pt++;
                while (pt < ch.length && isNumeric(ch[pt]))
                    outer_count = outer_count * 10 + (ch[pt++] - '0');
                if (outer_count == 0)
                    outer_count = 1;
                while (!elementStack.empty() && !elementStack.peek().isParen) {
                    Element element = elementStack.pop();
                    element.count *= outer_count;
                    elementList.add(element);
                }
                elementStack.pop();
                for (Element nElement : elementList)
                    elementStack.push(nElement);
            }
        }

        while (!elementStack.empty()) {
            Element top = elementStack.pop();
            ElementMap.put(top.name, ElementMap.getOrDefault(top.name, 0) + top.count);
        }

        StringBuilder ansBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : ElementMap.entrySet()) {
            ansBuilder.append(entry.getKey());
            if (entry.getValue() != 1)
                ansBuilder.append(entry.getValue());
        }
        return ansBuilder.toString();
    }

    public void work() {
        String formula = "(H2)(Mg)";
        System.out.println(countOfAtoms(formula));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
