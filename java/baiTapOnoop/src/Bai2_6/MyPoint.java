package Bai2_6;

import java.util.Scanner;

public class MyPoint {
private int x,y;

public MyPoint() {
this.x=0;
this.y=0;
}

public MyPoint(int x, int y) {
	this.x = x;
	this.y = y;
}

public int getX() {
	return x;
}

public void setX(int x) {
	this.x = x;
}

public int getY() {
	return y;
}

public void setY(int y) {
	this.y = y;
}
public int[] getXY(){
	return new int[] {x,y};
}
public void setXY(int x, int y) {
	this.x=x;
	this.y=y;
}
public double distance(int x, int y) {
	return 
}
@Override
public String toString() {
	return "MyPoint [x=" + x + ", y=" + y + "]";
}
public static void main(String[] args) {
	
}
}
