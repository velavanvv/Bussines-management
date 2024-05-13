package com.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.business.entities.User;

import com.business.repositories.UserRepository;

@Component
public class AdminServices
{
	

	@Autowired
	private UserRepository userRepo;
	
	//Get All Admins
	public List<User>getAll()
	{
		 List<User> admins = userRepo.findByRole("ADMIN");
		 return admins;
	}
	//Get Single Admin
	public User getAdmin(int id)
	{
		Optional<User> optional = this.userRepo.findById(id);
		User admin=optional.get();
		return admin;
	}
//Update Admin
	 public void update(User admin ,int id)
	{
		for (User ad : getAll()) 
		{
			if(ad.getU_id()==id)
			{
				this.userRepo.save(admin);
			}
		}
	} 
	
	//delete User
	public void delete(int id)
	{
		this.userRepo.deleteById(id);
	}
	
	//add Admin
	public void addAdmin(User admin)
	{
		this.userRepo.save(admin);
	}
	
	/* //Validating Admin login
	public boolean validateAdminCredentials(String email,String password)
	{
		Admin admin=adminRepository.findByAdminEmail(email);
		if(admin!=null && admin.getAdminPassword().equals(password))
		{
			return true;
		}
		return false;
	} */
}
