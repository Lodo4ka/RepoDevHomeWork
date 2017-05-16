import java.io.*;

/**
 * Created by lodo4ka on 15/05/2017.
 */
public class FileCopyUtil {


    public static void writeFile(String name, String description){



        try(OutputStream outputStream = new FileOutputStream("HomeWorkNumberNine/src/" + name);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)) {

            File file = new File(name);

            System.out.println(file.getAbsolutePath());

            outputStreamWriter.write(description);
        } catch (FileNotFoundException e) {
            String msg = "File " + name + " not found. Reason: " + e.getMessage();
            throw  new IllegalArgumentException(msg);
        } catch (IOException e) {
            String msg = "An error occurred while creating file writer for file name " + name + ". Reason:" + e.getMessage();
            throw new IllegalArgumentException(msg);
        }
    }
}
