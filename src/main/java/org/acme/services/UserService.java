package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entities.User;
import org.acme.repositories.UserRepository;

import java.util.*;

@ApplicationScoped
@Transactional
public class UserService {

    // @PersistenceContext
    // EntityManager entityManager;

    @Inject
    UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.listAll();
    }

    public User getUser(UUID id) {
        return userRepository.findById(id);
    }

    public UUID addUser() {
        User user = new User();
        userRepository.persist(user);
        return user.getId();
    }
}
