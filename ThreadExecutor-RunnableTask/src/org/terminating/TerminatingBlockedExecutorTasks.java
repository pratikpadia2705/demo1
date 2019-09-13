package org.terminating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.common.NamedThreadsFactory;
import org.tasks.LoopTaskA;
import org.tasks.LoopTaskG;





public class TerminatingBlockedExecutorTasks {

	public static void main(String[] args) throws InterruptedException {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool(new NamedThreadsFactory());
		
		LoopTaskA task1 = new LoopTaskA();
		LoopTaskG task2 = new LoopTaskG();
		
		
		Future<?> f1 = execService.submit(task1);
		Future<?> f2 = execService.submit(task2);
	
		
		execService.shutdown();
		
		TimeUnit.MILLISECONDS.sleep(2000);
		
		System.out.println("[" + currentThreadName + "] Invoking cancel() on all the tasks ...");
		f1.cancel(true);
		f2.cancel(true);
		//f3.cancel(true);
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
