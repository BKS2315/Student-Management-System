package com.masai.services;

import com.masai.entity.Admin;
import com.masai.exceptions.AdminException;

public interface AdminService {
	
	public Admin createAdmin(Admin admin) throws AdminException;

}
