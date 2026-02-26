package Excersize_01;

import java.io.FileOutputStream;
import java.io.IOException;

/// Try with multiple resources is used for avoiding the writing of finally() block 
/// WE can write multiple resources into try block
/// Also it will used for reducing the code of finally block
/// It will close automatically while finally block needed manual close
public class MultipleTryWithResourcesDemo {
    //public static void main(String[] args) throws IOException{
        // try{
        //     File file = new File("D:\\Ass1\\example.txt");
        //     FileWriter fw = new FileWriter(file);
        //     fw.write("This file is created for Trying the type of using multiple resources");
        //     FileReader fr = new FileReader(file);
        //     BufferedReader br = new BufferedReader(fr);
        //     br.close();
        //     System.out.println("SuccessFully Done!!");
        //     fw.close();
        //     fr.close();
        // }catch(IOException e){
        //     e.printStackTrace();
        // }

        


  public static void main(String[] args) {
    try {
      FileOutputStream output = new FileOutputStream("D:\\Ass1\\resource.txt");

      output.write("Hello".getBytes());

      output.close(); 

      System.out.println("Successful...");

    } catch (IOException e) {
      System.out.println("Error writing file.");
    }
  }
}
