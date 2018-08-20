package application;

import java.util.Random;

public class PrintTask implements Runnable {
	private int _sleepTime;
	private String _taskName;
	private Random _rnd = new Random();

    public PrintTask(String newTask)
    {
    	this._taskName = newTask;
    	this._sleepTime = this._rnd.nextInt(5000);

    }

    public void run()
    {
    	System.out.printf( "%s going to sleep for %d milliseconds.\n",
    			_taskName, _sleepTime );
    			try {
					Thread.sleep( _sleepTime );
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // put thread to sleep

    			System.out.printf( "%s done sleeping\n", _taskName );

    }


}
