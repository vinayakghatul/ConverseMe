package org.myspringtemplate.controller;

import org.myspringtemplate.service.FileMergerService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

import static org.mockito.Mockito.*;

public class FileMergerControllerTest {

    @Mock
    private FileMergerService fileMergerServiceTest;

    @InjectMocks
    private FileMergerController fileMergerControllerTest;

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mergeSortedFiles() throws IOException {

        File inputDir = temporaryFolder.newFolder("input");
        File outputDir = temporaryFolder.newFolder("output");

        File mockFile1 = new File(inputDir, "file1.dat");
        Files.write(mockFile1.toPath(), "Sample content".getBytes());

        String inputPath = inputDir.getAbsolutePath();
        String outputPath = new File(outputDir, "output.dat").getAbsolutePath();


        fileMergerControllerTest.mergeSortedFiles(inputPath, outputPath);

        Mockito.verify(fileMergerServiceTest, Mockito.atLeastOnce()).mergeSortedFiles(Arrays.asList(mockFile1), new File(outputPath));

    }

    @Test
    public void mergeSortedFile_No_Files_Found() throws IOException {
        File inputDir = temporaryFolder.newFolder("input");
        File outputDir = temporaryFolder.newFolder("output");


        String inputPath = inputDir.getAbsolutePath();
        String outputPath = new File(outputDir, "output.dat").getAbsolutePath();


        fileMergerControllerTest.mergeSortedFiles(inputPath, outputPath);

        Mockito.verify(fileMergerServiceTest, never()).mergeSortedFiles(anyList(), any(File.class));
    }
}