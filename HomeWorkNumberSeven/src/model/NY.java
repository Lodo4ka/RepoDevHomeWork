package model;

/**
 * Created by lodo4ka on 04/05/2017.
 */
public class NY implements City{


    private String name = "New York";
    private int population = 20_000_000;
    private int area = 141_000;

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
        System.out.println("City of United States");
    }

    @Override
    public String toString() {
        return "NY {" +
                "name = '" + name + '\'' +
                ", population = " + population +
                ", area = " + area +
                '}';
    }
}
