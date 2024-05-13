package com.business.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.business.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>
{
public User findByUemail(String email);

public List<User> findByRole(String role);
}
