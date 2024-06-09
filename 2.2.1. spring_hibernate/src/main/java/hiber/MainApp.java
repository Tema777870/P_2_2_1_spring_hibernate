package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//      userService.add(new User("User7", "Lastname7", "user5@mail.ru", new Car("BMW", 2019)));
//      userService.add(new User("User6", "Lastname6", "user6@mail.ru", new Car("Nissan", 2014)));
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
        try {
            System.out.println(userService.getUserByCar("BMW", 2019));
        } catch (NoResultException noResultException) {
            System.out.println("Ошибка! Пользователь с таким авто не найден");
        } catch (NonUniqueResultException nonUniqueResultException) {
            System.out.println("Ошибка! Пользователей с таким авто более одного.");
        } finally {
            context.close();
        }


    }
}
