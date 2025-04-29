package filesystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    private final String name;
    private final List<FileSystem> fileSystemList = new ArrayList<>();

    public Directory(String directoryName) {
        this.name = directoryName;
    }
    public void addFileSystem(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory: " + name);
        for (FileSystem fileSystem : fileSystemList) {
            fileSystem.ls();
        }
    }

    @Override
    public void delete(String fileName) {
        if(fileName.equals(name)) {
            for(FileSystem fileSystem : fileSystemList) {
                fileSystem.delete(fileSystem.getName());
            }
            fileSystemList.clear();
            System.out.println("Deleting directory: " + name);
        }else{
            for(FileSystem fileSystem : fileSystemList) {
                fileSystem.delete(fileName);
            }
        }
    }
    public void addFile(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    public List<FileSystem> getFileSystemList() {
        return fileSystemList;
    }

    public String getName() {
        return name;
    }
}
