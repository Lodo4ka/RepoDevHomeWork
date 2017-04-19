import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lodo4ka on 19/04/2017.
 */
public class SplittingString {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String sentence = "I like you 100 times, and you? I'm not sure about number 1.2345.";
        String[] arrayWords = (sentence + " ").split("\\p{P}?[ \\t\\n\\r]+");
        System.out.println("Please input the word -");
        String word = scanner.next();

        findWord(arrayWords, word);
    }

    public static void findWord(String[] array, String input) {

        for (int i = 0; i < array.length; i++) {
            if(input.contains(array[i].toLowerCase())){
                System.out.printf("This word: %s\nindex number: %d%n", array[i], i);
                return;
            }
            else {
            }
        }
    }
}
