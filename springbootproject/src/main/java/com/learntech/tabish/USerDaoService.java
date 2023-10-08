package com.learntech.tabish;

import com.learntech.tabish.beans.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class USerDaoService {

    DummyClass dummyClass;
    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(18)));
        users.add(new User(++userCount, "Badam", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount, "Jin", LocalDate.now().minusYears(25)));
    }


    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }

    public String getDemoStr() {
        return dummyClass.print();
    }
}
