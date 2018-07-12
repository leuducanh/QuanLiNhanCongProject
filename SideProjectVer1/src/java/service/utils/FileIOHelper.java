package service.utils;

import java.io.*;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;


public class FileIOHelper {

    public static File getFileFromName(String fileName){

        File file = Paths.get(Paths.get("").toFile().getAbsolutePath(), Paths.get("/src/resources/" + fileName).toFile().getAbsolutePath()).toFile();
        return file;
    }

    public static <T> boolean write(List<T> list, String fileName){

        try(FileOutputStream fos = new FileOutputStream(getFileFromName(fileName));
            ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static <T> List<T> read(String fileName) {
        List<T> employeeList = new LinkedList<>();

        try(FileInputStream fis = new FileInputStream(getFileFromName(fileName));
            ObjectInputStream ois = new ObjectInputStream(fis);) {
            employeeList = (List<T>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e){
            employeeList = new LinkedList<>();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

}
