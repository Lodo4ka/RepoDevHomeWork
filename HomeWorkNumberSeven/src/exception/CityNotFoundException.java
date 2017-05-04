package exception;

import java.io.IOException;

/**
 * Created by lodo4ka on 04/05/2017.
 */
public class CityNotFoundException extends RuntimeException {

    @Override
    public String getMessage() {
        return ("That city isn't found");
    }
}
