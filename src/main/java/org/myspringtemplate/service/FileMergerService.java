package org.myspringtemplate.service;

import java.io.File;
import java.util.List;

public interface FileMergerService {
    void mergeSortedFiles(List<File> sortedFiles, File outputFile);
}
