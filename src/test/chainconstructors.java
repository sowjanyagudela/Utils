/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author sowjanya
 */
public class chainconstructors {
    
    public chainconstructors(){
        System.out.println("Default");
    }
    
    public chainconstructors(int a, int b){
        this(b);
        System.out.println("in 1 constructor:"+ a+b);
    }
    
    public chainconstructors(int a){
        this();
        System.out.println("in @"+a);
        
    }
    
    public static void main(String[] args) {
        chainconstructors cc = new chainconstructors(5, 6);
    }
}
