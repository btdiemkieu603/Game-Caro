/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


public class Point {
	public int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point findStartXPoint() {
		int startX = x  < 0 ? 0 : x;
		return new Point(startX, y);
	}
	public Point findEndXPoint() {
		int endX = x  > 14 ? 14 : x;
		return new Point(endX, y);
	}
	public Point findStartYPoint() {
		int startY = y  < 0 ? 0 : y ;
		return new Point(x, startY);
	}
	public Point findEndYPoint() {
		int endY = y > 14 ? 14 : y ;
		return new Point(x, endY);
	}
	public Point findLeftTopPoint() {
		int startX = x < 0 ? 0 : x;
		int startY = y  < 0 ? 0 : y ;
		return new Point(startX, startY);
	}
	public Point findRightTopPoint() {
		int endX = x  > 14 ? 14 : x ;
		int startY = y  < 0 ? 0 : y ;
		return new Point(endX, startY);
	}
	public Point findLeftBottomPoint() {
		int startX = x  < 0 ? 0 : x ;
		int endY = y  > 14 ? 14 : y ;
		return new Point(startX, endY);
	}
	public Point findRightBottomPoint() {
		int endX = x  > 14 ? 14 : x ;
		int endY = y  > 14 ? 14 : y ;
		return new Point(endX, endY);
	}
	
	public void log() {
		System.out.println("x: "+ this.x + "| y: " + this.y);
	}
}

