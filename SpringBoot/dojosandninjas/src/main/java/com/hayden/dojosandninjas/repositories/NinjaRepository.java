package com.hayden.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hayden.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();
}
