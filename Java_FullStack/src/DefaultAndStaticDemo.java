//This is also a abstract interface because it contains only one abstract method multiple static and default methods are allowed

interface Iface{
	void sayHi();
	default void wishBirthDay() {
		System.out.println("Happy Birthday..");
	}
	static String wishADay(double time) {
		if(time > 6 && time <= 12)
			return "Good Morning!!";
		else if(time > 12 && time < 16 )
			return "Good Evening!!";
		else
			return "Good night!!";
	}
}

public class DefaultAndStaticDemo {

	public static void main(String[] args) {
		Iface iface = ()->{
			System.out.println("I am only abstract method sayHi");
		};
		iface.sayHi();
		iface.wishBirthDay();
		String msg = Iface.wishADay(6.49);
		System.out.println(msg);
	}

}
