import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lodo4ka on 15/05/2017.
 */
public class EntryPoint {

    public static void main(String[] args) throws IOException {

        System.out.println("Choose your version");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(reader.readLine());
        if(v == 1){
            System.out.println("Write file name");
            String name = reader.readLine();
            System.out.println("Write file description");
            String description = reader.readLine();
            FileCopyUtil.writeFile(name, description);
        }
    }
}
