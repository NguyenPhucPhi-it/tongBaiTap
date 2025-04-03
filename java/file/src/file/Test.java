package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String[] args) {
	List<Students> list=new ArrayList<>();
	//ghi du lieu
//	list.add(new Students("A","NAM"));
//	list.add(new Students("N","NAM"));
//	list.add(new Students("B","NU"));
//	FileOutputStream out=null;
//	ObjectOutputStream objectOutputStream=null;
//	try {
//		out = new FileOutputStream("students.dat");
//		
//		try {
//			objectOutputStream = new ObjectOutputStream(out);
//			objectOutputStream.writeObject(list);;
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	} catch (FileNotFoundException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}finally {
//		if(out!=null) {
//			try {
//				out.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		if(objectOutputStream!=null) {
//			try {
//				objectOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
//	
	
	//doc du lieu
	FileInputStream in=null;
	 ObjectInputStream objectInputStream=null;
	try {
		 in=new FileInputStream("studens.dat");
		  try {
			objectInputStream=new ObjectInputStream(in);
			try {
				list=(List<Students>) objectInputStream.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		if(in != null) {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(objectInputStream !=null) {
			try {
				objectInputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Ket qua: ");
		for(int i=0;i<list.size();i++) {
			list.get(i).display();
		}
	}
	
}
}
