// Services tem como objetivo fazer a conexão com o banco de dados e retornar seus dados
package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.acme.entities.User;

import java.util.Set;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.UUID;
import java.util.Optional;

@ApplicationScoped
public class UserService {

    private final Set<User> users = Collections.synchronizedSet(new LinkedHashSet<>());
    public Set<User> getUsers() {

        if (this.users.size() == 0) {
            this.users.add(new User(UUID.randomUUID(), "Marcos", 52));
            this.users.add(new User(UUID.randomUUID(), "Junior", 24));
            this.users.add(new User(UUID.randomUUID(), "Victor", 31));
            this.users.add(new User(UUID.randomUUID(), "Lucas", 27));
        }

        return this.users;
    }

    public Optional<User> getUser(String name) {

        var findUser = this.users.stream().filter(
                user -> user.getName().equals(name));
        return findUser.findFirst();
    }
}
