package com.masai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Admin;
import com.masai.exceptions.AdminException;
import com.masai.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adm;

	@Override
	public Admin createAdmin(Admin admin) throws AdminException {
		
		Admin existingAdmin= adm.findByUsername(admin.getUsername());
		
		if(existingAdmin != null) 
			throw new AdminException("Admin already registered with this username!");
		
		return adm.save(admin);
	}

}
