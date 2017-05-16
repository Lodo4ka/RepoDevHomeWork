import java.io.*;

/**
 * Created by lodo4ka on 16/05/2017.
 */
public class FIleReadUtil {


    public static void readFile(String s){

        try (BufferedReader in = new BufferedReader(new FileReader("HomeWorkNumberNine/src/"+ s));){

            String line = in.readLine();

            while (line !=null){
                System.out.println(line);
                line = in.readLine();
            }

        } catch (FileNotFoundException e) {
            String msg = "File " + s + " not found. Reason: " + e.getMessage();
            throw  new IllegalArgumentException(msg);
        } catch (IOException e) {
            String msg = "An error occurred while creating file writer for file name " + s + ". Reason:" + e.getMessage();
            throw new IllegalArgumentException(msg);
        }
    }
}
