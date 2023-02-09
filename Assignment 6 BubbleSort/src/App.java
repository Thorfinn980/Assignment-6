import java.util.Random; //For random array
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter; 
import java.io.IOException;
 


public class App {
    public static void main(String[] args) throws Exception {

        int arrayLength = 10;
        int[] sortedArray;
        int[] array = createRandomArray(arrayLength);

        //PURPOSE: Debug
        System.out.println("Original array:");
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println("\n");

        
        try 
        {
            writeArrayToFile(array, "assignment.txt");
            sortedArray = readFileToArray("assignment.txt");
            bubbleSort(sortedArray);

            System.out.println("Printing...");
            System.out.println("Sorted array:");

            for (int i = 0; i < sortedArray.length; i++) 
            {
              System.out.print(sortedArray[i] + " ");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred while reading from or writing to the file: " + e.getMessage());
        }
    }

    public static void bubbleSort(int[] array) 
    {
        //Bubblesort: one pop, one replace

        System.out.println("Sorting array...");
        int n = array.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
          for (int j = 0; j < n - i - 1; j++) 
          {
            if (array[j] > array[j + 1]) 
            {
              temp = array[j];
              array[j] = array[j + 1];
              array[j + 1] = temp;
            }
          }
        }
    }

    public static int[] createRandomArray(int arrayLength) 
    {
        //NOTE: If this method is accepting an arrayLength then... I would need to create a length in main

        Random random = new Random(); //NOTE: Generate random
        int[] array = new int[arrayLength]; //REMINDER: Create a new array with the assigned length
        System.out.println("Creating random array...");
        
        for (int i = 0; i < arrayLength; i++) 
        {
            array[i] = random.nextInt(101);
        }
        
        return array;
    }

    //Need to import FileWriter and IOException
    public static void writeArrayToFile(int[] array, String filename) throws IOException 
    {
        //OBJ: write the array to the file, with each line containing one integer in the array.
        FileWriter writer = new FileWriter(filename);

        System.out.println("Writing array to file...");
        for (int i = 0; i < array.length; i++) 
        {
          writer.write(String.valueOf(array[i]) + "\n");
        }
        writer.close();
    }

    //OBJ: read the integers (one line per integer) to an array, and return the array
    public static int[] readFileToArray(String filename) throws IOException 
    {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        System.out.println("Checking size...");
        //Phase one debugging:
        //The first while loop is used to determine the number of lines in the file, which is equivalent to the number of integers in the array.
        String line = br.readLine();
        int count = 0;
        while (line != null) {
          count++;
          line = br.readLine();
        }
        System.out.println("Count size: " + count);
        br.close();
    

        System.out.println("Reading file into array...");
        //Phase two
        //The second while loop is used to read the integers from the file, one line at a time, and store each integer in the array.
        int[] array = new int[count];

        fr = new FileReader(filename);
        br = new BufferedReader(fr);
        
        line = br.readLine();
        count = 0;
        while (line != null) {
          array[count++] = Integer.parseInt(line);
          line = br.readLine();
        }
        br.close();
        return array;
    }
}
