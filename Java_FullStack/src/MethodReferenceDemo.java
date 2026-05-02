import java.util.Arrays;
import java.util.List;

interface MyDemo{
	void info();
	public static void getName(String name) {
		System.out.println(name);
	}
}

class Demo implements MyDemo{
	public void info() {
		System.out.println("I am info from Demo class");
	}
	public static void getName(String name) {
		System.out.println(name);
	}
}

public class MethodReferenceDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Tanvi","Shruti","Gauri","Ruchika");
		list.forEach(System.out::println);
		Demo demo = new Demo();
		MyDemo m = demo::info;
		m.info();
		//name.forEach(demo::getName);
		//MyDemo d = Demo::getName;
	}

}
