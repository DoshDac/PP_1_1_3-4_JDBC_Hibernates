package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();

        User firstUser = new User("ali", "muradov", (byte) 21);
        User secondUser = new User("Leyla", "muradova", (byte) 19);
        User thirdUser = new User("Turpal", "muradov", (byte) 22);
        User fourthUser = new User("Lazina", "muradova", (byte) 3);

        userService.createUsersTable();


        userService.saveUser(firstUser.getName(), firstUser.getLastName(), firstUser.getAge());
        System.out.println("Член семьи" + ": " + firstUser.getName() + " добавлен в базу данных");
        userService.saveUser(secondUser.getName(), secondUser.getLastName(), secondUser.getAge());
        System.out.println("Член семьи" + ": " + secondUser.getName() + " добавлен в базу данных");
        userService.saveUser(thirdUser.getName(), thirdUser.getLastName(), thirdUser.getAge());
        System.out.println("Член семьи" + ": " + thirdUser.getName() + " добавлен в базу данных");
        userService.saveUser(fourthUser.getName(), fourthUser.getLastName(), fourthUser.getAge());
        System.out.println("Член семьи" + ": " + fourthUser.getName() + " добавлен в базу данных");

        List<User> resultList = userService.getAllUsers();
        for (User user : resultList) {
            System.out.println(user.toString());
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}