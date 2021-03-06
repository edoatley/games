package com.edoatley.repository;

import com.edoatley.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GamesRepository extends CrudRepository<Game, Integer> {

}
