package Day_08;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");
        System.out.println(sb);
        sb.append(" New Programming Language");
        System.out.println(sb);
        sb.delete(5,7);
        System.out.println(sb);
        sb.insert(5, "ne");
        System.out.println(sb);
        //sb.reverse();
        System.out.println(sb.reverse());
    }
}
