package com.edoatley.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edoatley.model.Night;

@Repository
public interface NightRepository extends CrudRepository<Night, Long> {

}
