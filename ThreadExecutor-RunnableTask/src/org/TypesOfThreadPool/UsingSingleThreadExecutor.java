package org.TypesOfThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.tasks.LoopTaskA;



public class UsingSingleThreadExecutor {
	
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		ExecutorService execService = Executors.newSingleThreadExecutor();
		
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		
		execService.shutdown();
		
		System.out.println("Main thread ends here...");
		
	}
}
