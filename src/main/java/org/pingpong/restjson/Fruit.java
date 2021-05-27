package org.pingpong.restjson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="Fruit")
@JsonPropertyOrder({"name", "decription"})
public class Fruit {

    // Las propiedades han de ser publicas para que jackson
    // pueda acceder a ellar por reflection o configurar getter y setter
    // Internamente Quarkus hace la propiedad public
    // Mantengo el getter porque lo uso en los casos test

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(unique = true)
    public String name;
    
    @NotEmpty
    @Column
    public String description;

    public Fruit() {
    }

    public Fruit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
