package me.a8kj.wizardscrapper.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class FileImpl implements File {

    private @NonNull final Path path;

    @Override
    public String getPath() {
        return path.toString();
    }

    @Override
    public String getName() {
        return path.getFileName().toString();
    }

    @Override
    public void create() {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to create file: " + getPath(), e);
        }
    }

    @Override
    public void delete() {
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete file: " + getPath(), e);
        }
    }

    @Override
    public void serve(FileService service) {
        service.process(this);
    }
}
