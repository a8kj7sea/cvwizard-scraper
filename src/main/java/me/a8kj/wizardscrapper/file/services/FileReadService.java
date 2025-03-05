package me.a8kj.wizardscrapper.file.services;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.wizardscrapper.file.File;
import me.a8kj.wizardscrapper.file.FileService;
import me.a8kj.wizardscrapper.structure.container.Container;

@RequiredArgsConstructor
@Getter
public class FileReadService implements FileService {

    private final Container<String> container;

    @Override
    public void process(File file) {
        try {
            container.setContent(Files.readString(Path.of(file.getPath()), StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
