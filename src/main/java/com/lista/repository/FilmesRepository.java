package com.lista.repository;

import org.springframework.data.repository.CrudRepository;

import com.lista.models.Filme;

public interface FilmesRepository extends CrudRepository<Filme, String>{

	Filme findById(long id);

}
