package org.test;

@FunctionalInterface
public interface Inter1 {
	
	public void helloMethod();
	
	default void defaultHelloMethod(){
		System.out.println("inside defaultHelloMethod");
	}
	public static void staticHelloMethod(){
		System.out.println("inside staticHelloMethod");
	}
}
