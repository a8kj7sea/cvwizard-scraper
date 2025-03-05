package me.a8kj.wizardscrapper.file;

public interface FileService {

    default Boolean canProcess(File file) {
        return null;
    }

    void process(File file);

}
