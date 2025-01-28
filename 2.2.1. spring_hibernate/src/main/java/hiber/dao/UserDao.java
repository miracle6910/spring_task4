package hiber.dao;

import hiber.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

//    List<User> findUseByCar(String model, int series);

    Optional<User> findUserByCar(String model, int series);
}
