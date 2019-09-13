package org.handleException;

import java.lang.Thread.UncaughtExceptionHandler;

import org.tasks.ExceptionLeakingTask;

public class HandlingUncaughtExceptions_DefaultsNOverrides {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		Runnable task = () -> {
			throw new RuntimeException();
		};
	
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("THE_DEFAULT_ONE"));
		
		Thread t1 = new Thread(task, "MyThread-1");
		
		Thread t2 = new Thread(task, "MyThread-2");
		t2.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom_Handler_1"));
		
		Thread t3 = new Thread(task, "MyThread-3");
		
		Thread t4 = new Thread(task, "MyThread-4");
		t4.setUncaughtExceptionHandler(new ThreadExceptionHandler("Custom_Handler_2"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
