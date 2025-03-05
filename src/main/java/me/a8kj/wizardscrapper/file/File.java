package me.a8kj.wizardscrapper.file;

public interface File extends FileMeta {

    void create();

    void delete();

    void serve(FileService service);

}
