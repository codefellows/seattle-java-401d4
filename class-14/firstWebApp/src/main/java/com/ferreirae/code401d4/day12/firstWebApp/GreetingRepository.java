package com.ferreirae.code401d4.day12.firstWebApp;

import org.springframework.data.repository.CrudRepository;

// sets up how Spring will interact with the database to retrieve/save/etc Greetings
public interface GreetingRepository extends CrudRepository<Greeting, Long> {

}
