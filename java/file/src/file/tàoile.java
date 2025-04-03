package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class tàoile {
	public static void main(String[] args) throws IOException {
		File file = new File("vidu.txt");
		if (file.exists()) {
			System.out.println("File exist");
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("File not found");
		}
		FileOutputStream fos = null;
		Scanner sc=new Scanner(System.in);
		try {
			fos = new FileOutputStream("testt.txt");
			String line="Nguyễn Phúc Phi dz" ;
			
			 byte[] b=line.getBytes();
			 fos.write(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
