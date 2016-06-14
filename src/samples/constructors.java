/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples;

/**
 *
 * @author sowjanya
 */
public class constructors {
    
  int length;
	int breadth;
	int height;
	public int getVolume() {
		return (length * breadth * height);
	}
	constructors() {
		length = 10;
		breadth = 10;
		height = 10;
	}
	constructors(int l, int b, int h) {
		length = l;
		breadth = b;
		height = h;
	}
	public static void main(String[] args) {
		constructors cubeObj1, cubeObj2;
		cubeObj1 = new constructors();
		cubeObj2 = new constructors(10, 20, 30);
		System.out.println("Volume of Cube1 is : " + cubeObj1.getVolume());
		System.out.println("Volume of Cube1 is : " + cubeObj2.getVolume());
	}
    
      
      
}
