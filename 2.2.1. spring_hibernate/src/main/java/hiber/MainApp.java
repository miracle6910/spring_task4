package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("Toyota", 2020);
      Car car2 = new Car("BMW", 2021);
      Car car3 = new Car("Mercedes-benz", 2022);
      Car car4 = new Car("Skoda", 2023);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru",car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru",car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru",car4));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car = "+user.getCar());
         System.out.println();
      }

      System.out.println("find user by model and series:");
      User userByCar = userService.getUserByCar("BMW", 2021);
      System.out.println(userByCar.getFirstName());
      System.out.println(userByCar.getLastName());
      System.out.println(userByCar.getCar().getModel());
      System.out.println(userByCar.getCar().getSeries());

      context.close();
   }
}
