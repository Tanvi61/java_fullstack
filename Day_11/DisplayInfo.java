package Day_11;

import java.util.ArrayList;

public class DisplayInfo {

	public static void main(String[] args) {
		ArrayList<StudentInfo> al = new ArrayList<StudentInfo>();
		StudentInfo info = new StudentInfo(32, "Tanvi", "A", 1234);
		StudentInfo info1 = new StudentInfo(05, "Shruti", "A", 5678);
		al.add(info);
		al.add(info1);
		System.out.println(info);
		System.out.println(info1);
		System.out.println(al);
	}

}

