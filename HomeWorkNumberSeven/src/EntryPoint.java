import exception.CityNotFoundException;
import factory.CityFactory;
import model.City;

import java.util.Scanner;

public class EntryPoint {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        CityFactory cityFactory = new CityFactory();

        String input = scanner.nextLine();
        City city = null;
        try {
            city = cityFactory.createCity(input);
        } catch (CityNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        city.getName();
        city.getPopulation();
        city.getArea();
        city.getHomeland();
    }

}
