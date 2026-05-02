package Day_09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPestWithBinaryData {
    public static void main(String[] args) throws IOException{
        FileInputStream fis =  new FileInputStream("E:\\Documents\\dart.jpg");//"E:\Documents\dart.jpg"
        FileOutputStream fos = new FileOutputStream("D:\\Ass1\\dart.jpg");
        int d = 0;
        while((d = fis.read())!= -1){
            fos.write((byte)d);
        }
        fis.close();
        fos.close();
        System.out.println("Successful..!!");
    }
}
