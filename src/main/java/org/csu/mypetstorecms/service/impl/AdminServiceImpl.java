package org.csu.mypetstorecms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.mypetstorecms.entity.Admin;
import org.csu.mypetstorecms.persistence.AdminMapper;
import org.csu.mypetstorecms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin getAdminByUsernameAndPassword(String username, String password) {
        // 构造条件查询器
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        // 链式调用，相当于设置两个条件，查表中username = username 且 password = password的
        queryWrapper.eq("username",username).eq("password",password);
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;
    }

    @Override
    public int insertAdmin(Admin admin) {
        return adminMapper.insert(admin);
    }

    @Override
    public Admin login(String username, String password) {
        Admin admin = this.getAdminByUsernameAndPassword(username, password);
        return admin;
    }
}
