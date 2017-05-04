package factory;

import exception.CityNotFoundException;
import model.City;
import model.London;
import model.Moscow;
import model.NY;

/**
 * Created by lodo4ka on 04/05/2017.
 */
public class CityFactory {

    public City createCity(String type) throws CityNotFoundException{


            if ("london".equalsIgnoreCase(type)) {
                return new London();
            } else if ("moscow".equalsIgnoreCase(type)) {
                return new Moscow();
            } else if ("new york".equalsIgnoreCase(type) || "ny".equalsIgnoreCase(type)) {
                return new NY();
            }
            else {
                throw new CityNotFoundException();
            }
    }
}
