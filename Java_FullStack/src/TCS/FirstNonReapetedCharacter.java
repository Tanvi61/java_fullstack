package TCS;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonReapetedCharacter {

	public static void main(String[] args) {
		String str = "tanvisantoshdeshmukh";
		
		LinkedHashMap<String,Long> collect = Arrays.stream(str.split("")).collect(Collectors
				.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		System.out.println(collect);
		
		String s1 = collect.entrySet().stream()
				.filter(e ->e.getValue()==1).map(e -> e.getKey()).findFirst().get();
		System.out.println(s1);
	}

}
