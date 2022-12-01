package com.fegseg.servicelmpl;

import com.fegseg.bean.AdminBean;
import com.fegseg.dao.AdminDao;
import com.fegseg.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminDao adminDao;

    @Override
    public List<AdminBean> getAll() {
        return adminDao.getAll();
    }

    @Override
    public AdminBean checking(String username, String password) {
        return adminDao.checking(username, password);
    }
}
