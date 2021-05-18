package com.backend.system.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public final class FileManager {

    public static Stream<Path> getFiles(Path path) throws IOException {
       return  Files.list(path);
    }

    public static void makeDir(Path path) throws IOException {
        Files.createDirectories(path);
    }


}
