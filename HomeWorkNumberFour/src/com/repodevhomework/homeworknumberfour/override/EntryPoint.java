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
        User user3 = new User();
        user3.setName("Petya");


        similarityObjects(user1, user2);
        similarityObjects(user1,user3);
    }

    public static void similarityObjects(User user1, User user2) {
        if(user1.equals(user2)){
            System.out.println("That's the same objects and hashcode similar");
        }
        else {
            System.out.println("That's different objects and hashcode various");
        }
    }
}
