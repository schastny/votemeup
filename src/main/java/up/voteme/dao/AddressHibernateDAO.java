package up.voteme.dao;

import org.hibernate.HibernateException;
import up.voteme.domain.Address;
import up.voteme.exception.dao.AddressDAOException;
import up.voteme.service.AddressDAO;


import static up.voteme.util.HibernateUtil.*;

public class AddressHibernateDAO implements AddressDAO {

    @Override
    public void addAddress(Address address) throws AddressDAOException {
        try {
            begin();
            getSession().save(address);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new AddressDAOException("Could't add address! " + address, e);
        }
    }

    @Override
    public void deleteAddress(Address address) throws AddressDAOException {
        try {
            begin();
            getSession().delete(address);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new AddressDAOException("Could't delete address! " + address, e);
        }
    }

    @Override
    public void updateAddress(Address address) throws AddressDAOException {
        try {
            begin();
            getSession().update(address);
            commit();
            closeSession();
        } catch(HibernateException e) {
            rollback();
            throw new AddressDAOException("Could't update address! " + address, e);
        }
    }

}
