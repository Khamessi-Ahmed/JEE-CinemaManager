package modele.metier;

import java.util.List;
import Dao.DaoUser;
import Dao.IDaoUser;
import modele.entities.User;

public class ModeleUser {
    private User user;
    private IDaoUser daoUser = new DaoUser();

    public List<User> getAllUsers() {
        return daoUser.getAllUsers();
    }

    public User addUser() {
        return daoUser.addUser(user.getEmail(), user.getPassword());
    }

    public int updateUser() {
        return daoUser.updateUser(user);
    }

    public void deleteUser(int id) {
        daoUser.deleteUser(id);
    }

    public User getUserById(int id) {
        return daoUser.getUserById(id);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        return daoUser.getUserByEmailAndPassword(email, password);
    }

    public void setUser(User user) {
        this.user = user;
    }
}
