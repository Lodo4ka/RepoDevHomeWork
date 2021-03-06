package com.repodevhomework.homeworknumberfour.inheritance.secondpackcge;

import com.repodevhomework.homeworknumberfour.inheritance.firstpackage.A;
import com.repodevhomework.homeworknumberfour.inheritance.firstpackage.B;

/**
 * Created by lodo4ka on 23/04/2017.
 */
public class C extends B{

    public C(int id, String name, boolean beginApp) {
        super(id, name, beginApp);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected void whoAreYou(String you) {
        super.whoAreYou(you);
    }

    @Override
    public boolean isBeginApp() {
        return super.isBeginApp();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    private void myName(String name){
        System.out.println("My name is " + name);
    }

    public static void main(String[] args) {

        A a = new A();
        B b = new B(01, "Bla", true);
        a.getName();
        b.getId();
        b.getName();
        b.isBeginApp();
        b.setBeginApp(true);
        b.setId(19);
        b.setName("Vova");
    }
}
