package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	File file=new File("vd.txt");
	
	//tao file
	if(file.exists()) {
	System.out.println("File exist");
//		file.delete();
	}else {
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File not found");
	}
	//ghi dữ liệu vào file
	FileOutputStream fos=null;
	Scanner sc=new Scanner(System.in);
	try {
		fos=new FileOutputStream("text.txt");
		for(;;) {
			System.out.println("Insert line into file: ");
			String line=sc.nextLine();
			byte[] b=line.getBytes();
			try {
				fos.write(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Continue Y/N");
			String choose = sc.nextLine();
			if(choose.equalsIgnoreCase("N"));
			break;
		}
		//fos.write(?);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}finally {
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
}
