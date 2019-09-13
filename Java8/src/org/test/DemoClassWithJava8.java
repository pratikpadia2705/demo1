package org.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DemoClassWithJava8  {

	public static void main(String[] args) {

		System.out.println("Called from DemoClassWithJava8 ");
		
		
		Inter1 inter1Obj = ()->{
			System.out.println("Hello");
		};
		
		inter1Obj.helloMethod();


		Inter2 inter2Obj = (s) -> {

			System.out.println("String  " + " \" " +s  + " \"" + "   length of = ");

			return s.length();

		};


		int lenghtCount = inter2Obj.getLength("pratik");
		
		
		System.out.println("String length : " +lenghtCount);


		Runnable task = () ->{
			for(int i=0;i<10;i++){
				System.out.println("child thread");
			}

		};
		new Thread(task).start();


		GenericInterface<String> reverse = (str) -> {
			String result = "";
			for (int i = str.length()-1; i >= 0 ; i--)
				result += str.charAt(i);
			return result;
		};
		System.out.println("Reverse string using Lambda = " + reverse.func("Lambda"));

		GenericInterface<Integer> factorial = (n) -> {
			int result = 1;
			for (int i = 1; i <= n; i++)
				result = i * result;
			return result;
		};
		System.out.println("factorial of 5 using Lambda = " + factorial.func(5));

		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(12);
		list.add(15);

		Collections.sort(list,     (i1,i2) -> (i1>i2)?-1 : (i1<i2)? 1 : 0);
		System.out.println("List: Descending order of sorting" + list);

		
		
		List<String> list2 = Arrays.asList("9", "A", "Z", "1", "B", "Y", "4", "a", "c");
		
		List<String> sortedList = list2.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());

		System.out.println("List: Descending order of all elements sorting" + sortedList);
		
		TreeSet<Integer>ts2 = new TreeSet<Integer>();
		ts2.add(10);
		ts2.add(30);
		ts2.add(40);
		System.out.println("TreeSet: natural order of sorting" + ts2);
		
		TreeSet<Integer>ts = new TreeSet<Integer> ((i1,i2) -> (i1>i2)?-1 : (i1<i2)? 1 : 0);
		ts.add(10);
		ts.add(30);
		ts.add(40);
		System.out.println("TreeSet: Descending order of sorting" + ts);
		
		
		
		
		TreeMap<Integer,String>tm = new TreeMap<Integer,String> (  (i1,i2) -> (i1>i2)?-1 : (i1<i2)? 1 : 0  )  ;
		tm.put(10,"pratik");
		tm.put(30, "rajan");
		tm.put(20, "ajay");
		System.out.println("Map: Descending order of sorting" + tm);


		//custom class sorting ascending

		List<Employee> lemp = new ArrayList<Employee>();
		lemp.add(new Employee(4,"ajay"));
		lemp.add(new Employee(3,"Mukesh"));
		lemp.add(new Employee(2,"Vikas"));
		lemp.add(new Employee(1,"Ramesh"));
		//Collections.sort( lemp);

		Collections.sort(lemp,(e1,e2)->(e1.eno<e2.eno)?-1:(e1.eno>e2.eno)?1:0);  


		System.out.println("custom class sorting in ascending order" +lemp);

		Runnable task2 = () -> { 
			for(int i=0;i<3;i++) {
				System.out.println("lambda thread");
			}
		};
		Thread t = new Thread(task2);
		t.start();


	}
}
