package org.acme.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
// Criar os getters e setters...

import java.util.UUID;

@Entity
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private int idade;

    private void User(String name, int idade) {
        this.name = name;
        this.idade = idade;
    }

    public UUID getId() {
        return id;
    }
}
