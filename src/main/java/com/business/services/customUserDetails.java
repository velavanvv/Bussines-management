package com.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.business.entities.User;

import com.business.repositories.UserRepository;


@Service
public class customUserDetails implements UserDetailsService{
@Autowired
private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
   
        User user = userRepository.findByUemail(username);
		if (user != null) {
			return user;
		}

		
        else {
            throw new UsernameNotFoundException("User or Admin not found with username: " + username);
        }


          }
    
}
