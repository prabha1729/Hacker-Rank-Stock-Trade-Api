package com.hackerrank.stocktrade.repo;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.stocktrade.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
