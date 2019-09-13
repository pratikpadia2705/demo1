package org.scheduling;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecutor_periodically {
	
	public static void main(String[] args) throws  ExecutionException, InterruptedException {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	  
		
		
		RunnableTask task1 = new RunnableTask ("Demo Task 1");
		CallableTask task2 = new CallableTask ("Demo Task 2");
		RunnableTask task3 = new RunnableTask ("Demo Task 3");
	    System.out.println("The time is : " + new Date());
	     
	    ScheduledFuture<?> result = executor.scheduleAtFixedRate(task1, 2, 5, TimeUnit.SECONDS);
	   
	    
	    ScheduledFuture<?> callbleresult = executor.schedule(task2, 5, TimeUnit.SECONDS);
	    
	      
		System.out.println("result of callable task return = " + callbleresult.get());
	    
	    try {
	        TimeUnit.MILLISECONDS.sleep(10000);
	    }
	    catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	     
	    executor.shutdown();
	}
	
}

