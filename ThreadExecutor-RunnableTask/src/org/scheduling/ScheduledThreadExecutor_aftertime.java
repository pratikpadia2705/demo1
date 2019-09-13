package org.scheduling;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadExecutor_aftertime {
	public static void main(String[] args)
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        RunnableTask task1 = new RunnableTask ("Demo Task 1");
        RunnableTask task2 = new RunnableTask ("Demo Task 2");
         
        System.out.println("The time is : " + new Date());
         
        executor.schedule(task1, 3 , TimeUnit.SECONDS);
        executor.schedule(task2, 2 , TimeUnit.SECONDS);
         
        try {
              executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
              e.printStackTrace();
        }
         
        executor.shutdown();
    }
}
