package org.myspringtemplate.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileMergerServiceImplTest {

    private FileMergerServiceImpl fileMergerService;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Before
    public void setup() {
        fileMergerService = new FileMergerServiceImpl();
    }

    @Test
    public void testMergeSortedFiles() throws IOException {
        // temporary input and output directories
        File inputDir = temporaryFolder.newFolder("input");

        File outputDir = temporaryFolder.newFolder("output");

        // input files
        File file1 = new File(inputDir, "file1.dat");
        File file2 = new File(inputDir, "file2.dat");

        Files.write(file1.toPath(), "apple\nbanana\n".getBytes());
        Files.write(file2.toPath(), "cherry\ndate\n".getBytes());

        // Define output file
        File outputFile = new File(outputDir, "merged.dat");

        // Perform the merge operation
        fileMergerService.mergeSortedFiles(Arrays.asList(file1, file2), outputFile);

        // Verify output file
        List<String> lines = Files.readAllLines(outputFile.toPath());
        // Assert result
        assertEquals(Arrays.asList("apple", "banana", "cherry", "date"), lines);
    }

    @Test
    public void testMergeSortedFiles_NoFiles() throws IOException {
        // Create temporary input and output directories
        File inputDir = temporaryFolder.newFolder("input");
        File outputDir = temporaryFolder.newFolder("output");

        // Define output file
        File outputFile = new File(outputDir, "merged.dat");

        // merge function call
        fileMergerService.mergeSortedFiles(Arrays.asList(), outputFile);

        // Verify - output file (empty)
        List<String> lines = Files.readAllLines(outputFile.toPath());
        // Assert result
        assertEquals(Arrays.asList(), lines);
    }
}
