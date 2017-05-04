import exception.CityNotFoundException;
import factory.CityFactory;
import model.City;

import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        CityFactory cityFactory = new CityFactory();

        String input = scanner.nextLine();
        City city = cityFactory.createCity(input);
        city.getName();
        city.getPopulation();
        city.getArea();
        city.getHomeland();
    }

}
