package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Bai1 {
public static void main(String[] args) {
	File file=new File("bai1.txt");
	FileOutputStream fos=null;
	FileInputStream fis=null;
	//FileReader fileReader=null;
	BufferedReader bufferedReader=null;
	if(file.exists()) {
		System.out.println("File exist");
	}else {
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File not found");
	}
	
	try {
		
		fos=new FileOutputStream("out.txt");
		fis=new FileInputStream("bai1.txt");
		//fileReader=new FileReader("odc.txt");
		bufferedReader=new BufferedReader(new FileReader("bai1.txt"));
		String line="Nguyễn Van A" ;
		
		 byte[] b=line.getBytes();
		 fos.write(b);
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
        e.printStackTrace();
	
}finally {
	if(fos!=null) {
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}if(fis!=null) {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
}
}