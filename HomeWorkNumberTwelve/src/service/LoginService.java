package service;

import entity.User;
import repository.UserRepository;

/**
 * Created by lodo4ka on 06/06/2017.
 */
public class LoginService {

    private UserRepository userRepository = new UserRepository();

    public boolean authorised(final User user) {


        return userRepository.exists(user);
    }
}
