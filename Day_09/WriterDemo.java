package Day_09;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
    public static void main(String[] args) {
        try{
            File file = new File("D:\\Ass1\\sample.txt");
            FileWriter fw = new FileWriter(file,true);  //Use true for appending the other statement
            FileReader fr = new FileReader(file);
            fr.read();
            fw.write("I am java developer");
            fw.close();
            System.out.println("Success");
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
