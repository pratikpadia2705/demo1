package org.scheduling;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class RunnableTask implements Runnable
	{
	    private String name;
	 
	    public RunnableTask(String name) {
	        this.name = name;
	        System.out.println("Executed Runnable task" +name);
	    }
	     
	    public String getName() {
	        return name;
	    }
	    
	    
	   

		@Override
	    public void run()
	    {
			String currentThreadName = Thread.currentThread().getName();
			System.out.print(currentThreadName);
	        try {
	            System.out.println("Doing a task during : " + name + " - Time - " + new Date());
	         /*   for(int i = 0 ; i<10; i++) {
	            	
	            //	System.out.println("tick " +i);
	            	//TimeUnit.MILLISECONDS.sleep(10000);
	            	
	            }*/
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

