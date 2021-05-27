package org.pingpong.restjson;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ServiceFruit {

    @Inject
    RepositoryFruit repo;

    public ServiceFruit() { 
        // CDI
    }

    public List<Fruit> list() {
        return repo.listAllOrderedByName();
    }

    public void add(Fruit fruit) {
        repo.persist(fruit);
    }

    public void remove(String name) {
        repo.deleteByName(name);
    }

    public Optional<Fruit> getFruit(String name) {
        return name.isBlank()? 
            Optional.ofNullable(null) : 
            repo.findByNameOptional(name);
    }
}
