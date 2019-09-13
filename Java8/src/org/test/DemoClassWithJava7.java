package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class DemoClassWithJava7 implements Inter1,Inter2,Runnable{

	/* Implemened methods of interfaces Inter1, Inter2 and Runnable */
	@Override
	public void helloMethod() {
		System.out.println("hello Method called");

	}


	@Override
	public int getLength(String s) {
		System.out.println("String  " + " \" " +s  + " \"" + "   length of = ");
		return s.length();

	}

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("child thread");
		}


	}



	public static void main(String[] args) {
		


		System.out.println("called from DemoClassWithJava7 ");
		DemoClassWithJava7 demoObjWithJava7 = new DemoClassWithJava7();
		demoObjWithJava7.helloMethod();


		int lengthOfString =  demoObjWithJava7.getLength("pratik");
		System.out.println(lengthOfString);


		Thread t = new Thread(new DemoClassWithJava7());
		t.start();


		//Desceneding order of list elements
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(12);
		list.add(15);
		Collections.sort(list,new MyComparator());
		System.out.println("List: Descending order of sorting" + list);


		//default order ascending 
		// custom sorting descending
		TreeSet<Integer>ts = new TreeSet<Integer> (new MyComparator());
		ts.add(12);
		ts.add(20);
		ts.add(5);
		System.out.println("Set: Descending order of sorting" + ts);

		TreeMap<Integer,String>tm = new TreeMap<Integer,String> ( new MyComparator() )  ;
		tm.put(10,"pratik");
		tm.put(30, "rajan");
		tm.put(20, "ajay");
		System.out.println("Map: Descending order of sorting" + tm);


		Runnable task = new Runnable(){

			public void run(){
				for(int i=0;i<3;i++){
					System.out.println("anonymous inner class task  inside run method");
				}
			}};


			Thread t2 = new Thread(task);
			t2.start();

			Inter1.staticHelloMethod();   //invoking static method of interface 1


			demoObjWithJava7.defaultHelloMethod();
			


	}
	public void defaultHelloMethod(){
		Inter1.super.defaultHelloMethod();  // invoking default method of interface1
	}


}
