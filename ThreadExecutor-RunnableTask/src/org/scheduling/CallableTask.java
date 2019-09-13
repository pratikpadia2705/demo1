package org.scheduling;

import java.util.Date;
import java.util.concurrent.Callable;

public class CallableTask implements Callable
{
    private String name;
 
    public CallableTask(String name) {
        this.name = name;
        System.out.println("Executed Callable task" +name);
    }
     
    public String getName() {
        return name;
    }
    
    
   

	

	@Override
	public Object call() throws Exception {
		String currentThreadName = Thread.currentThread().getName();
		System.out.print(currentThreadName);
		
		  System.out.println("Executed callable task!");
          return "Called!";
	}

}
