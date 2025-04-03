package svdaluong;

import java.util.ArrayList;
import java.util.List;

public class SharedData {
	public static final int THREAD_1=1;
	public static final int THREAD_2=2;
	public static final int THREAD_3=3;
	
List<Student> validRolNumber;
List<String> unvalidRollNumber;
int currentThread;
boolean isAlive;
public SharedData() {
	validRolNumber=new ArrayList<>();
	unvalidRollNumber=new ArrayList<>();
	currentThread=0;
	isAlive=true;
}
public List<Student> getValidRolNumber() {
	return validRolNumber;
}
public void setValidRolNumber(List<Student> validRolNumber) {
	this.validRolNumber = validRolNumber;
}
public List<String> getUnvalidRollNumber() {
	return unvalidRollNumber;
}
public void setUnvalidRollNumber(List<String> unvalidRollNumber) {
	this.unvalidRollNumber = unvalidRollNumber;
}
public int getCurrentThread() {
	return currentThread;
}
public void setCurrentThread(int currentThread) {
	this.currentThread = currentThread;
}
public boolean isAlive() {
	return isAlive;
}
public void setAlive(boolean isAlive) {
	this.isAlive = isAlive;
}


}
