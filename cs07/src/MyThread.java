class MyThread implements Runnable {
	volatile boolean suspended = false;
	volatile boolean stopped = false;

	Thread th;

	MyThread() {
		this.th = new Thread(this);
	}

	void start() {
		th.start();
	}

	void stop() {
		stopped = true;
	}

	void suspend() {
		suspended = true;
	}

	void resume() {
		suspended = false;
	}

	@Override
	public void run() {
		int i = 0;

		while (!stopped) {
			if (!suspended) {
				if (i % 600000000 == 0) {
					System.out.println(i);
				}
				i++;
			}
		}
	}
}
