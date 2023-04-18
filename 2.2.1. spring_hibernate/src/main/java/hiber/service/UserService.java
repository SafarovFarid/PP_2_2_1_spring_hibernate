package hiber.service;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

    void add(User user);
    void add(User user, Car car);
    List<User> listUsers();


    User owner(String model, int series);


}
