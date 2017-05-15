import java.io.*;

/**
 * Created by lodo4ka on 15/05/2017.
 */
public class FileCopyUtil {


    public static void copy1(String inputFileName, String description){

        try( FileReader fileReader = new FileReader(inputFileName);
             FileWriter fileWriter = new FileWriter(description);){

            File inputFile = new File(inputFileName);

            System.out.println(inputFile.getAbsolutePath());


            int c;
            while((c = fileReader.read()) != -1){
                fileWriter.write(c);
            }
        }
        catch (FileNotFoundException e){
            String msg = "File " + inputFileName + " not found. Reason: " + e.getMessage();
            throw  new IllegalArgumentException(msg);
        } catch (IOException e) {
            String msg = "An error occurred while creating file writer for file name " + description + ". Reason:" + e.getMessage();
            throw new IllegalArgumentException(msg);
        }
    }




    public static void copy2(String inpuFileName, String outputFileName){

        try (FileInputStream fileInputStream = new FileInputStream(inpuFileName);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)){


            int c;
            while ((c = bufferedInputStream.read()) !=-1){

                bufferedOutputStream.write(c);
            }

        } catch (FileNotFoundException e) {
            String msg = "File " + inpuFileName + " not found. Reason: " + e.getMessage();
            throw  new IllegalArgumentException(msg);
        } catch (IOException e) {
            String msg = "An error occurred while creating file writer for file name " + outputFileName + ". Reason:" + e.getMessage();
            throw new IllegalArgumentException(msg);        }


    }

    public static void writeFile(String name, String description){



        try(OutputStream outputStream = new FileOutputStream(name);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream)) {

            File file = new File("/HomeWorkNumberNine/src/" + name);

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
