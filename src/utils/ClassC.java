/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author sowjanya
 */
public class ClassC extends ClassA {

    public void test() {
        //calling super class method
        doSomething();
    }
    public static void main(String[] args) {
        ClassC c = new ClassC();
        c.doSomething();
    }
}
