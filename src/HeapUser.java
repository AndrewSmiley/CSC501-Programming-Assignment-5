import java.io.*;
import java.util.ArrayList;

/**
 * Created by Andrew on 4/11/17.
 */
public class HeapUser {
    public static void main(String[] args) {
        //create something to store our numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        //attempt to open the file
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("prog4in3.txt")));
            //reference for our line
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }

            br.close();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        //add the numbers from the array into the binary tree
        for (Integer i : numbers) {

        }
    }
}
