
import java.util.ArrayList;
import java.util.ListIterator;
public class ListMethods {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("Tanvi");
		arr.add("Shruti");
		System.out.println(arr);
		System.out.println(arr.contains("Tanvi"));  //It returns boolean value 
		
		ListIterator<String> li = arr.listIterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}
		System.out.println("-----------");
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
	}

}
