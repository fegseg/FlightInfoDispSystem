package com.fegseg.service;


import com.fegseg.bean.AdminBean;

import java.util.List;

public interface AdminService {
    public List<AdminBean> getAll();

    public AdminBean checking(String username, String password);
}
