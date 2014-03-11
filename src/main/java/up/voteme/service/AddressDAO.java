package up.voteme.service;

import up.voteme.domain.Address;
import up.voteme.exception.dao.AddressDAOException;

public interface AddressDAO {

    public void addAddress(Address address) throws AddressDAOException;

    public void deleteAddress(Address address) throws AddressDAOException;

    public void updateAddress(Address address) throws AddressDAOException;

}
