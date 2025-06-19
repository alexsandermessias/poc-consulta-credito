package util;

public class Interrupter implements Runnable {

	private final Thread main;
	private final Integer interval;

	public Interrupter(Thread main, Integer interval) {
		this.main = main;
		this.interval = interval;

	}

	public void run() {
		try {
			wait(interval);
			main.interrupt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
