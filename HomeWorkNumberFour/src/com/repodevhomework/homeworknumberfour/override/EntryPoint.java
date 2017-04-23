package com.repodevhomework.homeworknumberfour.override;

/**
 * Created by lodo4ka on 23/04/2017.
 */
public class EntryPoint {


    public static void main(String[] args) {

        User user1 = new User();
        user1.setName("Vasya");
        User user2 = new User();
        user2.setName("Vasya");

        System.out.println("user1 hash = " + user1.hashCode());
        System.out.println("user2 hash = " + user2.hashCode());
    }
}
