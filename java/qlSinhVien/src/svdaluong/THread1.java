package svdaluong;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class THread1 extends Thread{
SharedData sharedData;

public THread1(SharedData sharedData) {

	this.sharedData = sharedData;
}
@Override
	public void run() {
	FileReader reader=null;
	BufferedReader bReader=null;
		try {
			 reader=new FileReader("Student.txt");
			 bReader=new BufferedReader(reader);
			String line=null;
			try {
				while((line=bReader.readLine()) != null) {
					synchronized (sharedData) {
						boolean isValid=Student.checkValliRolNo(line);
						if(isValid) {
							Student std=new Student(line);
							sharedData.getValidRolNumber().add(std);
							sharedData.setCurrentThread(SharedData.THREAD_2);
							
						}else {
							sharedData.getUnvalidRollNumber().add(line);
							sharedData.setCurrentThread(SharedData.THREAD_3);
							
						}
						sharedData.notifyAll();
						try {
							sharedData.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(bReader!=null) {
				try {
					bReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
