package com.yfy.beem.serverv2.dao;

import com.yfy.beem.serverv2.datamodel.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface of which Spring will generate an implementation to access the remote database where user data is stored.
 * */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
