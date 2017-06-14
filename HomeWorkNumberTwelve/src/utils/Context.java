package utils;

import entity.User;

/**
 * Created by lodo4ka on 13/06/2017.
 */
public class Context {

    static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Context.user = user;
    }
}
