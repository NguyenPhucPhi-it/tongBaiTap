package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadFile {
private static final String FileInputStream = null;
private static final String FileOutputStream = null;

public static void main(String[] args) {
	FileInputStream fis=null;
	FileOutputStream fileOutputStream=null;
	
	
	try {
		
		fis=new FileInputStream("text.txt");
		fileOutputStream=new FileOutputStream("test_cp.txt");
		//doc du lieu tu file vd:vidu 1
//		int code=fis.read();
//		char c=(char) code;
//		System.out.println("c>>"+c );
//		StringBuilder b=new StringBuilder();
//		
//		int code;
//		while((code = fis.read()) !=-1) {
//			b.append((char)code);			
//		}
//		String content=b.toString();
//		System.out.println(content);
		
		//docj du lieu tu file tung ki tu
		int ch;
		while((ch=fis.read()) !=-1) {
			System.out.println((char) ch);
			fileOutputStream.write(ch);
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(FileInputStream !=null) {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		if(FileOutputStream !=null) {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
}
}