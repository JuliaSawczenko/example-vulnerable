package engineering;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class InsecureDeserializationExample {

    public Object loadObject(String filePath) throws Exception {
        try (ObjectInputStream ois =
            new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        }
    }

    public Object safeLoad(String filePath) throws Exception {
        // A safer approach would use a validation step or custom ObjectInputFilter
        return null;
    }
}