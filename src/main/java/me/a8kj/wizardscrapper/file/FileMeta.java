package me.a8kj.wizardscrapper.file;

public interface FileMeta {

    String getPath();

    String getName();

    default String getDescription() {
        return null;
    }
}
