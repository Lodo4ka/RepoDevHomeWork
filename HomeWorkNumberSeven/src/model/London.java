package model;

public class London implements City{

    private String name = "London";
    private int population = 9_000_000;
    private int area = 1_740_000;

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
        System.out.println("City of United Kingdom, That is Capital of England");
    }

    @Override
    public String toString() {
        return "London{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
