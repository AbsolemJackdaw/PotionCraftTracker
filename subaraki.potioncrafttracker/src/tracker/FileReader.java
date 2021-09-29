package tracker;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReader {

    private String folder;
    private static final String FORMAT = ".tracker";

    public static final FileReader INSTANCE = new FileReader("saves");

    public FileReader(String folder) {
        this.folder = "./" + folder + "/";
    }

    public void saveToFile(String filename, Object o) {
        getOrCreatePath();
        try (ObjectOutputStream stream = new ObjectOutputStream(Files.newOutputStream(Path.of(folder + filename + FORMAT)))) {
            stream.writeObject(o);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

    public Object readFromFile(String filename) {
        getOrCreatePath();
        try {
            ObjectInputStream stream = new ObjectInputStream(Files.newInputStream(Path.of(folder + filename + FORMAT)));
            return stream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return null;
    }

    private void getOrCreatePath() {
        Path dir = Path.of(folder);
        if (!Files.exists(dir)) {
            try {
                Files.createDirectory(dir);
            } catch (IOException e) {
                e.printStackTrace(System.err);
            }
        }
    }
}
