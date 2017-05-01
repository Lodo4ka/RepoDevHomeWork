package website;

import factory.Developer;

/**
 * Created by lodo4ka on 01/05/2017.
 */
public class PhpDeveloper implements Developer{
    @Override
    public void writeCode() {
        System.out.println("Php developer writes php code...");
    }
}
