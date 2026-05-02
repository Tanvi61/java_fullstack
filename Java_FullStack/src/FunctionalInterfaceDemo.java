
//interface Say{
//	void sayHello(String name);
//}
//
//public class FunctionalInterfaceDemo {
//
//	public static void main(String[] args) {
//		//By using Lambda function
//		//But it is only allowed when we have functional interface
//		Say say = (String name)->{
//			System.out.println("Hello Friends.. "+name);
//		};
//		say.sayHello("Tanvi");
//	}
//
//}

interface Say{
	String sayHello(String name);
}

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		//By using Lambda function
		//But it is only allowed when we have functional interface
		Say say = (String name)->{
			System.out.println("Hello Friends.. "+name);
			return name.toUpperCase();
		};
		String s = say.sayHello("Tanvi");
		System.out.println(s);
	}

}
