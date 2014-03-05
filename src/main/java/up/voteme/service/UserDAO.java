package up.voteme.service;

import up.voteme.domain.User;

import java.util.List;

public interface UserDAO
{
    public void addUser(User user);

    public void deleteUser(User user);

    public User getUserById(int id);

    public List<User> getAllUsers();

    public User getUserByLogin(String login);

    public void updateUser(int id);

    public void close();
}
