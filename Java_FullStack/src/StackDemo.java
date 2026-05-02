import java.util.Enumeration;
import java.util.Stack;

public class StackDemo {

	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();
		st.push("Tanvi");
		st.push("Shruti");
		st.push("Gauri");
		st.push("Ruchika");
		//First in Last Out
		System.out.println(st);
		st.pop();
		System.out.println(st);
		System.out.println(st.peek());
		//Enumeration used for performing operations on legacy class data
		Enumeration<String> em = st.elements();
		while(em.hasMoreElements()) {
			System.out.println(em.nextElement());
		}
		for(String str:st) {
			System.out.println(st);
		}
	}

}
