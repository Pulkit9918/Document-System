package com.example.DocumentReviewSystemGroup9.service;

import com.example.DocumentReviewSystemGroup9.bean.Admin;

public interface AdminService {
	Admin loginAdmin(int adminID, String password);
}
