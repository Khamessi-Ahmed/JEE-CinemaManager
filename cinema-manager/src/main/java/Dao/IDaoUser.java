package Dao;

import java.util.List;
import modele.entities.User;

public interface IDaoUser {
    public List<User> getAllUsers();
    public User addUser(String email, String password);
    public int updateUser(User user);
    public void deleteUser(int id);
    public User getUserById(int id);
    public User getUserByEmailAndPassword(String email, String password);
}
