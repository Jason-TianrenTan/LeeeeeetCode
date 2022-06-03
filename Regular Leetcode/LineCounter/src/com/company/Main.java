package com.company;

import com.company.Utils.FileLineRetriever;
import com.company.Utils.FileThread;
import com.company.Utils.LineCountListener;

import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        new FileLineRetriever().work(args);
    }

}
