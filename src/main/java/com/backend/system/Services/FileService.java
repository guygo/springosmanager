package com.backend.system.Services;

import com.backend.system.entities.OsFiles;
import com.backend.system.helpers.FileManager;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
public class FileService {

    public List<OsFiles> listFiles(Path path) throws IOException {
        Stream<Path> fileList = FileManager.getFiles(path);
        List<OsFiles> files = new ArrayList<>();
        fileList.forEach(p -> {
            File f = new File(p.toAbsolutePath().toString());

            OsFiles ff = new OsFiles();
            ff.setName(f.getName());
            ff.setPath(p.toAbsolutePath().toString());
            if (f.isDirectory()) {
                ff.setSize(getDirectorySizeJava8(f.toPath()));
            } else {
                try {
                    long bytes = Files.size(f.toPath());
                    ff.setSize(bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            files.add(ff);
        });
        return files;
    }

    private long getDirectorySizeJava8(Path path) {

        long size = 0;

        // need close Files.walk
        try (Stream<Path> walk = Files.walk(path)) {

            size = walk
                    //.peek(System.out::println) // debug
                    .filter(Files::isRegularFile)
                    .mapToLong(p -> {
                        // ugly, can pretty it with an extract method
                        try {
                            return Files.size(p);
                        } catch (IOException e) {
                            System.out.printf("Failed to get size of %s%n%s", p, e);
                            return 0L;
                        }
                    })
                    .sum();

        } catch (IOException e) {
            System.out.printf("IO errors %s", e);
        }

        return size;

    }


}
