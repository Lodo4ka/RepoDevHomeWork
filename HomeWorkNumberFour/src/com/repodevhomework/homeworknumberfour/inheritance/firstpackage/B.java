package com.repodevhomework.homeworknumberfour.inheritance.firstpackage;

/**
 * Created by lodo4ka on 23/04/2017.
 */
public class B {

    int id;
    String name;
    boolean beginApp;

    public B(int id, String name, boolean beginApp) {
        this.id = id;
        this.name = name;
        this.beginApp = beginApp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBeginApp() {
        return beginApp;
    }

    public void setBeginApp(boolean beginApp) {
        this.beginApp = beginApp;
    }

    private void intimProblems(String problem){
        System.out.println(problem);
    }

    protected void whoAreYou(String you){
        System.out.println("You are " + you);
    }

    int calculateStrength(int a, int b, int c){
        return a + b + c;
    }



}
