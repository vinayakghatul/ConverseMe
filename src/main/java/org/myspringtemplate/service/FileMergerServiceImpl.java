package org.myspringtemplate.service;

import org.myspringtemplate.DTO.NextLine;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class FileMergerServiceImpl implements FileMergerService{

    /**
     * mergeSortedData - This will merge sorted list of words in different files
     *
     * @param - List<File> - ArrayList of sorted files
     * @param - outputFile - Output file that will store merged and sorted list of words
     * @return - void
     */

    public void mergeSortedFiles(List<File> sortedFiles, File outputFile) {

        // Initialize priority queue
        PriorityQueue<NextLine> pq = new PriorityQueue<>();
        //Initialize buffered readers list to track readers
        List<BufferedReader> readers = new ArrayList<>();

        try {
            for (File file : sortedFiles) {
                // Initialize reader for each file
                BufferedReader br = new BufferedReader(new FileReader(file));
                // Add new bufferedReader to the list
                readers.add(br);

                // Add first word of each file to the priority queue
                String word = br.readLine();

                if (word != null) {
                    pq.add(new NextLine(word, br));
                }
            }

            // Initialize the bufferedWriter for output file
            // TWR - Try with resource to take care of resource closure after use
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

                while (!pq.isEmpty()) {
                    // Polling for smallest word
                    NextLine line = pq.poll();
                    bw.write(line.word);
                    bw.newLine();

                    // Write next word to Priority Queue
                    String newWord = line.br.readLine();
                    if (newWord != null) {
                        pq.add(new NextLine(newWord, line.br));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close all the resources
            for (BufferedReader br: readers) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
