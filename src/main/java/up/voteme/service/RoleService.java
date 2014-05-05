package up.voteme.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import up.voteme.domain.Role;

public interface RoleService {

	public abstract List<Role> findAll();

	public abstract List<String> findAllString();

}