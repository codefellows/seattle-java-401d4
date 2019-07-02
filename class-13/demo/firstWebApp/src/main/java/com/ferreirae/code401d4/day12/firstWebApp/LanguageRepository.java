package com.ferreirae.code401d4.day12.firstWebApp;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
    // match exactly (method name and parameter name) with the nameInEnglish property in the Language class
    public List<Language> findByNameInEnglish(String nameInEnglish);
}
