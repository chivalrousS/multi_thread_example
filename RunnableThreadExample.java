package chapter8;

public class RunnableThreadExample implements Runnable{
	public int count = 0;
	
	public void run()
	{
		System.out.println("RunnableThread starting...");
		try {
			while(count < 5)
			{
				Thread.sleep(500);
				System.out.println("In thread,count is " + count);
				++count;
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		    System.out.println("RunnableThread interrupted");
		}
		System.out.println("RunnableThread terminating");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnableThreadExample example = new RunnableThreadExample();
		Thread thread = new Thread(example);
		thread.start();
		
		while(example.count != 5)
		{
			try
			{
				Thread.sleep(250);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
