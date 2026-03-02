
interface myFace{
	void sayHello();
}

class MyFaceImpl implements myFace{
	@Override
	public void sayHello() {
		System.out.println("Hello Friends..!!");
	}
}

public class WithOutFunctionalInterfaceDemo {

	public static void main(String[] args) {
		MyFaceImpl my = new MyFaceImpl();
		my.sayHello();

	}

}
