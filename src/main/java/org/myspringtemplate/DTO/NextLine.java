package org.myspringtemplate.DTO;

import java.io.BufferedReader;

public class NextLine implements Comparable<NextLine>{
    public String word;
    public BufferedReader br;

    public  NextLine(String word, BufferedReader br) {
        this.word = word;
        this.br = br;
    }

    @Override
    public int compareTo(NextLine nextLine) {
        return this.word.compareTo(nextLine.word);
    }
}
