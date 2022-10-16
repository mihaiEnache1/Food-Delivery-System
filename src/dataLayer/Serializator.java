package dataLayer;

import java.io.*;

public class Serializator {
    public void serialization(String fileName, Object o) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(o);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public Object deserialization(String fileName) {
        Object o;
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            o = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException ioException) {
            return null;
        }
        return o;
    }
}
