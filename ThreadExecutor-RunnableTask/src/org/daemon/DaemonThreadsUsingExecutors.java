package org.daemon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.common.DaemonThreadsFactory;
import org.tasks.LoopTaskD;




public class DaemonThreadsUsingExecutors {

	public static void main(String[] args) {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("[" + currentThreadName + "] Main thread starts here...");
		
		ExecutorService execService = Executors.newCachedThreadPool(new DaemonThreadsFactory());
		
		execService.execute(new LoopTaskD(100));
		execService.execute(new LoopTaskD(200));
		execService.execute(new LoopTaskD(300));
		execService.execute(new LoopTaskD(400));
		
		execService.shutdown();
		
		System.out.println("[" + currentThreadName + "] Main thread ends here...");
	}
}
