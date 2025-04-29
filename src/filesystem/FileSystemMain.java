package filesystem;

public class FileSystemMain {
    public static void main(String[] args) {

        Directory directory = new Directory("entertainment");
        directory.addFileSystem(new Directory("movie"));
        directory.addFileSystem(new Directory("music"));
        directory.addFileSystem(new Directory("podcast"));
        FileSystem movie1 = new File("movie1");
        FileSystem movie2 = new File("movie2");
        ((Directory)directory.getFileSystemList().get(0)).getFileSystemList().add(movie1);
        ((Directory)directory.getFileSystemList().get(0)).getFileSystemList().add(movie2);
        ((Directory)directory.getFileSystemList().get(0)).getFileSystemList().add(new Directory("old-movie"));
        FileSystem music1 = new File("music1");
        FileSystem music2 = new File("music2");
        ((Directory)directory.getFileSystemList().get(1)).getFileSystemList().add(music1);
        ((Directory)directory.getFileSystemList().get(1)).getFileSystemList().add(music2);
        FileSystem podcast1 = new File("podcast1");
        FileSystem podcast2 = new File("podcast2");
        ((Directory)directory.getFileSystemList().get(2)).getFileSystemList().add(podcast1);
        ((Directory)directory.getFileSystemList().get(2)).getFileSystemList().add(podcast2);
        directory.addFileSystem(new File("spare file 1"));
        directory.addFileSystem(new File("spare file 2"));
        directory.ls();
        directory.delete("movie");
        directory.ls();
    }
}
