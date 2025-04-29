package filesystem;

public class File implements FileSystem{
    private String name;

    public File(String fileName) {
        this.name = fileName;
    }

    public void delete(String fileName) {
        if(fileName.equals(this.name)) {
            System.out.println("Deleting file: " + fileName);
        }
    }

    @Override
    public void ls() {
        System.out.println("File: " + name);
    }

    public String getName() {
        return name;
    }
}
