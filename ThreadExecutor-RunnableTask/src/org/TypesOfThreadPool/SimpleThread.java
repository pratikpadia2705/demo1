package org.TypesOfThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SimpleThread {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		//task1
		Runnable task1=new Runnable(){  


			public void run(){  
				System.out.println("*************Task1  without lambda ********************");
				System.out.println(Thread.currentThread().getName()); 
				System.out.println("Hi task1 without lambda");  
			}  
		};  
		Thread t1=new Thread(task1);  
		t1.start();  

		//task2
		Runnable task2=new Runnable(){  
			public void run(){  
				System.out.println();
				System.out.println("*************Task2  without lambda ********************");
				System.out.println(Thread.currentThread().getName()); 
				System.out.println("Hi task1 without lambda");  
			}  
		};  
		Thread t2=new Thread(task2);  
		t2.start();  


		//Thread Example with lambda  

		//task1
		Runnable task1WithLambda=()->{  
			System.out.println();
			System.out.println("*************Task1  with lambda ********************");
			System.out.println(Thread.currentThread().getName()); 
			System.out.println("hi task1 with lambda");  


		};  

		new Thread(task1WithLambda).start();

		//task2
		Runnable task2WithLambda=()->{  
			System.out.println();
			System.out.println("*************Task2  with lambda ********************");
			System.out.println(Thread.currentThread().getName()); 
			System.out.println("hi task2 with lambda");  

		};  
		new Thread(task2WithLambda).start();

		System.out.println("Main method completed");
		
		//Using executor
		
		ExecutorService executor = Executors.newCachedThreadPool();
		executor. execute (   () -> {
			System.out.println();
			System.out.println("*************Runnable Task1 With Executor service ********************");
			
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello task1 " + threadName);
		});
		executor. execute (   () -> {
			System.out.println();
			System.out.println("************* Runnable Task2 With Executor service ********************");
		
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello task2" + threadName);
		});
		
		Future<Integer> future  = executor. submit (   () -> {
			System.out.println();
			System.out.println("************* Callable Task3 With Executor service ********************");
		
		    String threadName = Thread.currentThread().getName();
		    System.out.println("Hello task3" + threadName);
		    return 123;
		});
		System.out.println("future done? " + future.isDone());
		Integer result = future.get();
		System.out.println("result of callable task = " +result);
		
		executor.shutdown();
	}


}
