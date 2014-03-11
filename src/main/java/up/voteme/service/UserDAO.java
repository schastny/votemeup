package up.voteme.service;

import up.voteme.domain.User;
import up.voteme.exception.dao.UserDAOException;

import java.util.List;

public interface UserDAO {
    public void addUser(User user) throws UserDAOException;

    public void deleteUser(User user) throws UserDAOException;

    public User getUserById(int id) throws UserDAOException;

    public List<User> getAllUsers() throws UserDAOException;

    public User getUserByLogin(String login) throws UserDAOException;

    public void updateUser(User user) throws UserDAOException;
}
