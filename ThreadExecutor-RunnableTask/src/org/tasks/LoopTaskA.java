package org.tasks;
import java.util.concurrent.TimeUnit;

public class LoopTaskA implements Runnable {
	private static int count = 0;
	private int id;
	
	@Override
	public void run() {
		String currentThreadName = Thread.currentThread().getName();
		System.out.println("##### <TASK-" + id + "> STARTING #####");
		System.out.println(Thread.currentThread().getName());
		for (int i=3; i>0; i--) {
			System.out.println("<TASK-" + id + ">TICK TICK " + i);
			
			try {
				TimeUnit.MILLISECONDS.sleep((long)(Math.random() * 1000));
			} catch (InterruptedException e) {
				
				System.out.println("***** [" + currentThreadName + "] <" + id + "> Sleep Interrupted. Cancelling ...");
				break;
			}
		}
		
		System.out.println("***** <TASK-" + id + "> DONE ******");
	}
	
	
	public LoopTaskA() {
		this.id = ++count;
	}
}
