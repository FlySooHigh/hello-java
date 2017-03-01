package com.flysoohigh.homeTask.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

class ThreadSynchonizationTest extends Thread
{
//	static AtomicInteger counter = new AtomicInteger(0);
	private static int counter;
	private Integer number;
	
	public ThreadSynchonizationTest(Integer num)
	{
		this.number = num;
	}
	
	public void run()
	{
//		synchronized(ThreadTest.class)
		synchronized(number)
		{
			for(int i = 0; i < 10_000; i++)
			{
//				counter.getAndIncrement();
				counter++;
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException 
	{
		Integer number = new Integer(1);
		
		Thread thread1 = new ThreadSynchonizationTest(number);
		Thread thread2 = new ThreadSynchonizationTest(number);
		
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		System.out.println(counter);
	}
}
