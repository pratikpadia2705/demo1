package org.naming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import org.common.NamedThreadsFactory;
import org.tasks.LoopTaskA;



public class NamingExecutorThreads {
	private static int count = 0;
	private static String NAME = "MyThread-";
	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadsFactory());
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		execService.execute(new LoopTaskA());
		
		//java 8 way
		ThreadFactory execService2 =(r)->{
			
			String NAME = "Custom MyThread-";
			Thread t = new Thread(r, NAME + ++NamingExecutorThreads.count);
			return t;
		};
		ExecutorService execService3 = Executors.newCachedThreadPool(execService2);
		
		execService3.execute(new LoopTaskA());
		execService3.execute(new LoopTaskA());
		execService3.execute(new LoopTaskA());
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
