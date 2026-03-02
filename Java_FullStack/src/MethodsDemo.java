
import java.util.HashSet;
public class MethodsDemo {

	public static void main(String[] args) {
		//HashSet and it's methods
		HashSet<Integer> hashset = new HashSet<Integer>();
		MethodsDemo md = new MethodsDemo();
		hashset.add(101);
		hashset.add(102);
		hashset.add(103);
		hashset.add(104);
		hashset.add(102);  //Use for adding the elements into the hashSet
		System.out.println("HashSet Elements are : "+hashset);  //Printing the object of hashSet
		System.out.println("Is this element is present or not : "+hashset.contains(104));  //Check the element is present or not
		System.out.println("Hashcode method : "+md.hashCode());  //It prints the HashCode value of this class
		System.out.println("isEmpty method on HashSet : "+hashset.isEmpty());  //It checks the hashSet is empty or not
		hashset.remove(102); // Remove one element from the HashSet
		System.out.println("After removing one element : "+hashset);
		System.out.println("It returns the size of the collection : "+hashset.size()); //Returns the size of collection
		
	}

}
