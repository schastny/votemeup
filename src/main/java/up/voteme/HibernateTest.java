package up.voteme;


import up.voteme.dao.DAOFactory;
import up.voteme.domain.User;
import up.voteme.service.UserDAO;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: St1ch
 * Date: 01.03.14
 * Time: 13:15
 * Package name: up.voteme
 * Project name: votemeup
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
        DAOFactory factory = DAOFactory.getFactory(DAOFactory.HibernateMySqlDAO);
        UserDAO userDAO = factory.createUserDAO();

        User ivan = new User();
        ivan.setLogin("eggplant");
        ivan.setEmail("redtube@mail.com");
        ivan.setCity("Shkolnoe");
        ivan.setDateOfBirth(new Date());

        userDAO.addUser(ivan);

        User sasha = new User();
        sasha.setLogin("pussy");
        sasha.setEmail("homeless@mail.com");
        sasha.setCity("Yalta");
        sasha.setDateOfBirth(new Date());

        userDAO.addUser(sasha);


        List<User> users = userDAO.getAllUsers();

        User user = userDAO.getUserByLogin("eggplant");
        userDAO.close();

        System.out.println(user.getLogin());
    }
}