package Excersize_01;

public class StringMethodDemo {

    public static void main(String[] args) {

        String str = "  Hello Java World  ";
        String str2 = "hello java world";

        System.out.println("Original String: '" + str + "'");

        // 1. length()
        System.out.println("Length: " + str.length());

        // 2. trim()
        System.out.println("Trimmed: '" + str.trim() + "'");

        // 3. toUpperCase()
        System.out.println("Uppercase: " + str.toUpperCase());

        // 4. toLowerCase()
        System.out.println("Lowercase: " + str.toLowerCase());

        // 5. charAt()
        System.out.println("Character at index 2: " + str.charAt(2));

        // 6. substring()
        System.out.println("Substring (2 to 7): " + str.substring(2, 7));

        // 7. contains()
        System.out.println("Contains 'Java'? " + str.contains("Java"));

        // 8. equals()
        System.out.println("Equals str2? " + str.equals(str2));

        // 9. equalsIgnoreCase()
        System.out.println("Equals Ignore Case? " + str.trim().equalsIgnoreCase(str2));

        // 10. replace()
        System.out.println("Replace Java with Python: " + str.replace("Java", "Python"));

        // 11. startsWith()
        System.out.println("Starts with '  He'? " + str.startsWith("  He"));

        // 12. endsWith()
        System.out.println("Ends with 'ld  '? " + str.endsWith("ld  "));

        // 13. indexOf()
        System.out.println("Index of 'Java': " + str.indexOf("Java"));

        // 14. lastIndexOf()
        System.out.println("Last Index of 'l': " + str.lastIndexOf("l"));

        // 15. isEmpty()
        String emptyStr = "";
        System.out.println("Is Empty? " + emptyStr.isEmpty());

        // 16. concat()
        System.out.println("Concatenation: " + str.concat("!!!"));

        // 17. split()
        String sentence = "Java is a programming language";
        String[] words = sentence.split(" ");
        System.out.println("Split words:");
        for (String word : words) {
            System.out.println(word);
        }

        // 18. valueOf()
        int number = 100;
        String numStr = String.valueOf(number);
        System.out.println("String value of number: " + numStr);

        // 19. compareTo()
        System.out.println("CompareTo str2: " + str.trim().compareTo(str2));

        // 20. join() (Java 8+)
        String joined = String.join("-", "Java", "Python", "C++");
        System.out.println("Joined String: " + joined);
    }
}
