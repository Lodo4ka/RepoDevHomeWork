package banking;

import factory.Developer;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code...");
    }
}
