package service;

import entity.User;
import repository.UserRepository;

/**
 * Created by lodo4ka on 06/06/2017.
 */
public class RegistrationService {

    private UserRepository userRepository = new UserRepository();

    public void register(final User user) {

        userRepository.create(user);

    }
}
