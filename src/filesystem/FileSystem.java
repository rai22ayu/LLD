package filesystem;

public interface FileSystem {
    void ls();
    void delete(String fileName);
    String getName();
}
