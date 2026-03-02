import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("Pune", 12);
		hm.put("Nashik", 15);
		hm.put("Sambhajinagar", 20);
		hm.put("Mumbai", 01);
		hm.put("Satara", 11);
		//Only one null key is allowed and it is set always index number 0
		hm.put(null, null);
		System.out.println(hm);
		System.out.println(hm.containsKey("pune"));
		System.out.println(hm.containsValue(20));
		System.out.println(hm.hashCode());
		System.out.println(hm.isEmpty());
		System.out.println(hm.size());
		int value = hm.get("Nashik");
		System.out.println(value);
		Set<String> keys = hm.keySet();
		System.out.println(keys);
		Collection<Integer> val = hm.values();
		System.out.println(val);
		//Enhanced for loop for separating the values 
		for(int i:val) {
			System.out.println(i);
		}
		for(String s:keys) {
			System.out.println(s);
		}
	}

}
