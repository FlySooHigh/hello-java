package concurrency.strkk.multiCompetition;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiCompetition
{
	private static final int FINISH_LINE = 30;
	
	public static void main(String[] args)
	{
		Judge judge = new Judge();
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
		List<Future<Result>> futures = new ArrayList<>();
		List<Callable<Result>> callables = new ArrayList<>();
		
		try(Scanner sc = new Scanner(System.in);)
		{
			System.out.println("Enter number of participants: ");
			int participants = sc.nextInt();
			System.out.println("Enter number of laps: ");
			int lapsNumber = sc.nextInt();
			
			int charCode = 65;
			for (int i = 1; i <= participants; i++)
			{
				String callableName = Character.toString((char)charCode) + Character.toString((char)charCode) + Character.toString((char)charCode);
				charCode++;
				callables.add(new Participant(FINISH_LINE, callableName, cyclicBarrier, judge));
			}
			
			for (int laps = 0; laps < lapsNumber; laps++)
			{
				for (Callable<Result> callable : callables)
				{
					futures.add(fixedThreadPool.submit(callable));
				}
			}
			
			int counter = 0;
			System.out.printf("%3s  %5s   %s %n", "Name", "Time", "Place");
			for(Future<Result> future : futures)
			{
				try
				{
					Result result = future.get();
					System.out.printf("%-5s  %-7.3f  %d%n", result.getName(), result.getTime(), result.getPlace());
					counter++;
					if (counter == participants)
					{
						System.out.println();
						counter = 0;
					}
				}
				catch (InterruptedException | ExecutionException e)
				{
					System.out.println(e);
				}
			}
		}
		fixedThreadPool.shutdown();
	}
}

class Judge
{
	private AtomicInteger placeCounter = new AtomicInteger(1);
	
	public int getPlace()
	{
		return placeCounter.getAndIncrement();
	}
	
	public void reset()
	{
		placeCounter.set(1);
	}
}

class Participant implements Callable<Result>			
{
	private int finishLine;
	private String name;
	private CyclicBarrier cyclicBarrier;
	private Judge judge;
	
	public Participant(int finishLine, String name, CyclicBarrier cyclicBarrier, Judge judge)
	{
		this.finishLine = finishLine;
		this.name = name;
		this.cyclicBarrier = cyclicBarrier;
		this.judge = judge;
	}

	@Override
	public Result call() throws Exception
	{
		cyclicBarrier.await();
		judge.reset();
		
		long startTime = System.currentTimeMillis();
		
		int position = 0;
		Random pace = new Random();
		while (position <= finishLine)
		{
			position += pace.nextInt(10);
			Thread.sleep(position * 10);
		}
		
		long finishTime = System.currentTimeMillis();
		
		return new Result(name, (finishTime - startTime)/1000.0, judge.getPlace());
	}
}

class Result
{
	private String name;
	private Double time;
	private Integer place;
	
	public Result(String name, Double time, Integer place)
	{
		this.name = name;
		this.time = time;
		this.place = place;
	}

	public String getName()
	{
		return name;
	}

	public Double getTime()
	{
		return time;
	}

	public Integer getPlace()
	{
		return place;
	}
}