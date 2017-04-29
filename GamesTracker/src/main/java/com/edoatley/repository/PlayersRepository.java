package com.edoatley.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edoatley.model.Player;

@Repository
public interface PlayersRepository extends CrudRepository<Player, Long> {

}
