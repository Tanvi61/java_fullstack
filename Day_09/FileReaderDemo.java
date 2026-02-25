package Day_09;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args)throws IOException {
        File file = new File("D:\\Ass1\\sample.txt");
        FileReader fr = new FileReader(file);
        int d;
        while((d = fr.read())!= -1){
            System.out.println((char)d);  //System.out.println((byte)d);  // For opening the file in byte format
        }
        fr.close();
    }
}
