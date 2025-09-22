package com.example.DocumentReviewSystemGroup9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DocumentReviewSystemGroup9.bean.Admin;
import com.example.DocumentReviewSystemGroup9.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository adminRepository;
	@Override
	public Admin loginAdmin(int adminID, String password) {
		Admin admin = adminRepository.findByAdminID(adminID);
		if(admin != null && admin.getAdminPassword().equals(password)) {
			return admin;
		}
		return null;
	}

}
