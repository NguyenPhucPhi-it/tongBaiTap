package BaiToanBanAn;

import java.util.Random;

public class Thread1 extends Thread{
SharedData sharedData;
public Thread1(SharedData sharedData) {
	this.sharedData = sharedData;
	
}
@Override
	public void run() {
		Random random=new Random();
		for(int i=0;i<5;i++) {
			System.out.println("Nguoi thu :"+i);
			synchronized (sharedData) {
				int rad = random.nextInt(5);
				sharedData.rad=rad;
				System.out.println("Nguoi thu>>" + rad);
				sharedData.notifyAll();
			}
			try {
				sharedData.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
	}
}
