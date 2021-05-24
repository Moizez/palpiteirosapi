package br.com.palpiteiros.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.palpiteiros.api.model.User;
import br.com.palpiteiros.api.repository.UserRepository;
import br.com.palpiteiros.api.util.EntityService;

/*User Service that uses the data persistence layer*/

@Service
public class UserService implements EntityService<User> {
	/*
	 * Using the data persistence layer
	 */
	@Autowired
	private UserRepository repository;

	/*
	 * default service methods
	 */

	@Override
	public void save(User entity) {
		repository.saveAndFlush(entity);
	}

	@Override
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<User> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Optional<User> login(String email, String password) {
		return repository.findByEmailAndPassword(email, password);
	}

}
