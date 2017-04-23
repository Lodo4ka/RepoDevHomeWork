package com.repodevhomework.homeworknumberfour.inheritance.firstpackage;

/**
 * Created by lodo4ka on 23/04/2017.
 */
public class A {

    String name;

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void say(){
        System.out.println("Hello Bastard");
    }

    protected String sayWhatsUp(){
       return "What's up world";
    }

    int calculatenumber(int a, int b){
        return a + b;
    }
}
