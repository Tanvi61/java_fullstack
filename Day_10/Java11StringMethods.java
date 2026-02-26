package Day_10;

public class Java11StringMethods {

    public static void main(String[] args) {

        String str = "   Hello Java 11   ";

        String blankStr = "   ";
        //System.out.println("isBlank(): " + blankStr.isBlank());

        //System.out.println("strip(): '" + str.strip() + "'");

        //System.out.println("stripLeading(): '" + str.stripLeading() + "'");

        //System.out.println("stripTrailing(): '" + str.stripTrailing() + "'");

        String multiLine = "Java\nPython\nC++";
        System.out.println("lines():");
        //multiLine.lines().forEach(System.out::println);

        //System.out.println("repeat(3): " + "Hi ".repeat(3));
    }
}