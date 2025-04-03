package chuabaitapt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thread2 extends Thread{
	List<Character> list=new ArrayList<>();

	@Override
	public void run() {
		int min = (int) 'a';
		int max = (int) 'z';
		int limit = max - min;
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			int rad = random.nextInt(limit);
			char ch = (char) (min+rad);
			list.add(ch);
			System.out.println("t2>>"+ch);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
