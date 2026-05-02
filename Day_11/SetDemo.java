package Day_11;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetDemo {

	public static void main(String[] args) {
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		set.add("Tanvi");
		set.add("Shruti");
		set.add("Tanvi");
		System.out.println(set.contains("shruti"));
		System.out.println("LinkedHashSet : "+set);
		
		HashSet<Integer> hashset = new HashSet<Integer>();
		hashset.add(10);
		hashset.add(40);
		hashset.add(40);
		hashset.add(25);
		System.out.println("HashSet : "+hashset);
		System.out.println(hashset.contains(40));
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.add(6);
		tree.add(41);
		tree.add(89);
		tree.add(25);
		System.out.println("TreeSet : "+tree);
		System.out.println(tree.contains(41));
	}

}

