package org.handleException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.tasks.ExceptionLeakingTask;




public class HandlingExecutorUncaughtExceptionsForEveryThread {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		Thread.setDefaultUncaughtExceptionHandler(new ThreadExceptionHandler("DEFAULT_HANDLER"));
		
		ExecutorService execService1 = Executors.newCachedThreadPool();
		Runnable task = () -> {
			throw new RuntimeException();
		};
		execService1.execute(task);
		execService1.execute(task);
		execService1.execute(task);
		
		ExecutorService execService2 = Executors.newCachedThreadPool();
		execService2.execute(task);
		execService2.execute(task);
		execService2.execute(task);
		
		execService1.shutdown();
		execService2.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
