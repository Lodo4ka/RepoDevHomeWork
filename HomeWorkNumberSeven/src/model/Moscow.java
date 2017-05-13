package model;

/**
 * Created by lodo4ka on 04/05/2017.
 */
public class Moscow implements City{

    private String name = "Moscow";
    private int population = 13_000_000;
    private int area = 2500;


    @Override
    public void getName() {
        System.out.println("City name is " + name);
    }

    @Override
    public void getPopulation() {
        System.out.println("Population are " + population + " of people");
    }

    @Override
    public void getArea() {
        System.out.println("Area is " + area + " kilometers");
    }

    @Override
    public void getHomeland() {
        System.out.println("City of Russia, That is Capital of Russia");
    }

    @Override
    public String toString() {
        return "Moscow {" +
                "name= '" + name + '\'' +
                ", population = " + population +
                ", area = " + area +
                '}';
    }
}
