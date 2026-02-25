package Excersize_01;

public class StringBuilderMethodDemo {

    public static void main(String[] args) {

        // Creating StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");

        System.out.println("Original StringBuilder: " + sb);

        // 1. append()
        sb.append(" Java");
        System.out.println("After append(): " + sb);

        // 2. insert()
        sb.insert(5, " Beautiful");
        System.out.println("After insert(): " + sb);

        // 3. replace()
        sb.replace(6, 15, "Amazing");
        System.out.println("After replace(): " + sb);

        // 4. delete()
        sb.delete(6, 14);
        System.out.println("After delete(): " + sb);

        // 5. deleteCharAt()
        sb.deleteCharAt(5);
        System.out.println("After deleteCharAt(): " + sb);

        // 6. reverse()
        sb.reverse();
        System.out.println("After reverse(): " + sb);

        // 7. length()
        System.out.println("Length: " + sb.length());

        // 8. capacity()
        System.out.println("Capacity: " + sb.capacity());

        // 9. ensureCapacity()
        sb.ensureCapacity(50);
        System.out.println("After ensureCapacity(50): " + sb.capacity());

        // 10. charAt()
        System.out.println("Character at index 2: " + sb.charAt(2));

        // 11. setCharAt()
        sb.setCharAt(2, 'X');
        System.out.println("After setCharAt(): " + sb);

        // 12. substring()
        System.out.println("Substring (1 to 4): " + sb.substring(1, 4));

        // 13. indexOf()
        System.out.println("Index of 'a': " + sb.indexOf("a"));

        // 14. lastIndexOf()
        System.out.println("Last index of 'a': " + sb.lastIndexOf("a"));

        // 15. toString()
        String str = sb.toString();
        System.out.println("Converted to String: " + str);

        // 16. setLength()
        sb.setLength(5);
        System.out.println("After setLength(5): " + sb);
    }
}
