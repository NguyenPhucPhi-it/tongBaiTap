package svdaluong;

import java.util.regex.Pattern;

public class Student {
String rolNo;

public Student() {
	
}

public Student(String rolNo) {

	this.rolNo = rolNo;
}

public String getRolNo() {
	return rolNo;
}

public void setRolNo(String rolNo) {
	this.rolNo = rolNo;
}
public static boolean checkValliRolNo(String rolNo) {
	String patterm="[CTN][0-9]{4}[G-M][V]?[0-9]{4}";
	boolean matches=Pattern.matches(patterm, rolNo);
	return matches;
}
}
