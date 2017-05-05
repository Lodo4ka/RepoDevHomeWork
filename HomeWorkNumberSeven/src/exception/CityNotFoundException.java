package exception;

import java.io.IOException;

/**
 * Created by lodo4ka on 04/05/2017.
 */
public class CityNotFoundException extends RuntimeException {

    String type;


    public CityNotFoundException(String type) {
        this.type = type;
    }

    @Override
    public String getMessage() {
        return ("That city \""+ type +"\" isn't found");
    }
}
