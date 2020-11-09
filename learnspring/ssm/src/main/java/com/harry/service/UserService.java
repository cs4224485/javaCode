package com.harry.service;

        import com.harry.bean.User;

        import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    List<User> selectUser();

    User selectUserById(int id);

    void deleteUser(int id);
}
