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
      context.getBean(UserService.class);


      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("X5", 528));
      userService.add(new User("User2", "Lastname2", "user1@mail4.ru"), new Car());
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"),new Car("X6", 570));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"),new Car("s-class", 128));

      List<User> users = userService.listUsers();

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      User userid = userService.owner("s-class", 128);

      System.out.println("\n" + "id = " + userid.getId() + "\n" + "First Name = " + userid.getFirstName() + "\n" +
              "Last Name = " + userid.getLastName() + "\n" + "Email = " + userid.getEmail());

      context.close();
   }
}
