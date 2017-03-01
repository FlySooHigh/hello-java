package com.flysoohigh.homeTask.concurrency;

public class DeadlockWithRunnable 
{
	public static Object Lock1 = new Object();
	public static Object Lock2 = new Object();

	public static void main(String args[]) 
	{
		Thread T1 = new Thread(new Runnable1());
		Thread T2 = new Thread(new Runnable2());
		T1.start();
		T2.start();
	}

	private static class Runnable1 implements Runnable
	{
		public void run() 
		{
			synchronized (Lock1) 
			{
				System.out.println("Thread 1: Holding lock 1...");
				System.out.println("Thread 1: Waiting for lock 2...");

				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException ex){}
				
				synchronized (Lock2) 
				{
					System.out.println("Thread 1: Holding lock 1 & 2...");
				}
			}
		}
	}

	private static class Runnable2 implements Runnable
	{
		public void run() 
		{
			synchronized (Lock2) 
			{
				System.out.println("Thread 2: Holding lock 2...");
				System.out.println("Thread 2: Waiting for lock 1...");

				synchronized (Lock1) 
				{
					System.out.println("Thread 2: Holding lock 1 & 2...");
				}
			}
		}
	} 
}
