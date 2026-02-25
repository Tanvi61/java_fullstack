package Excersize_01;


public class StringBufferMethodsDemo {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello");

        // 1 append()
        sb.append(" Java");
        System.out.println("1. append(): " + sb);

        // 2 insert()
        sb.insert(5, " World");
        System.out.println("2. insert(): " + sb);

        // 3 replace()
        sb.replace(6, 11, "Earth");
        System.out.println("3. replace(): " + sb);

        // 4 delete()
        sb.delete(6, 11);
        System.out.println("4. delete(): " + sb);

        // 5 deleteCharAt()
        sb.deleteCharAt(5);
        System.out.println("5. deleteCharAt(): " + sb);

        // 6 reverse()
        sb.reverse();
        System.out.println("6. reverse(): " + sb);

        // 7 capacity()
        System.out.println("7. capacity(): " + sb.capacity());

        // 8 ensureCapacity()
        sb.ensureCapacity(50);
        System.out.println("8. ensureCapacity(): " + sb.capacity());

        // 9 length()
        System.out.println("9. length(): " + sb.length());

        // 10 setLength()
        sb.setLength(5);
        System.out.println("10. setLength(): " + sb);

        // 11 charAt()
        System.out.println("11. charAt(): " + sb.charAt(2));

        // 12 setCharAt()
        sb.setCharAt(2, 'X');
        System.out.println("12. setCharAt(): " + sb);

        // 13 substring()
        System.out.println("13. substring(): " + sb.substring(0, 3));

        // 14 subSequence()
        System.out.println("14. subSequence(): " + sb.subSequence(0, 3));

        // 15 indexOf()
        System.out.println("15. indexOf(): " + sb.indexOf("X"));

        // 16 lastIndexOf()
        sb.append("X");
        System.out.println("16. lastIndexOf(): " + sb.lastIndexOf("X"));

        // 17 trimToSize()
        sb.trimToSize();
        System.out.println("17. trimToSize(): " + sb.capacity());

        // 18 toString()
        System.out.println("18. toString(): " + sb.toString());

        // 19 append(boolean)
        sb.append(true);
        System.out.println("19. append(boolean): " + sb);

        // 20 append(int)
        sb.append(100);
        System.out.println("20. append(int): " + sb);
    }
}
