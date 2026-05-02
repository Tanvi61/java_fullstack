package Day_08;

public class StringOperation {
    public static void main(String[] args) {
        /// Differnce between == and .equals() method
        String str = new String("Java");
        String str1 = new String("Java");
        // String s = "Tanvi";
        // String t = "Tanvi";

        String str2 = str.concat(" is a programming language");
        System.out.println(str2);
        String[] arr = str2.split(" ");
        System.out.println(arr.length);
        if(str.equals(str1))    //if(s == t)
            System.out.println("Both string have same content");
        else
            System.out.println("Both strings have differnt content");
    }
}
