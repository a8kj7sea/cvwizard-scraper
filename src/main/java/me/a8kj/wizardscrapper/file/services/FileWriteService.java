package me.a8kj.wizardscrapper.file.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.wizardscrapper.file.File;
import me.a8kj.wizardscrapper.file.FileService;

@RequiredArgsConstructor
@Getter
public class FileWriteService implements FileService {

    private final String content;

    @Override
    public void process(File file) {
        try {
            Files.write(Path.of(file.getPath()), content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
