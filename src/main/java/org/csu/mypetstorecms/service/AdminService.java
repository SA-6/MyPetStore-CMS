package org.csu.mypetstorecms.service;

import org.csu.mypetstorecms.entity.Admin;

public interface AdminService {
    public Admin getAdminByUsernameAndPassword(String username,String password);

    public int insertAdmin(Admin admin);

    public Admin login(String username, String password);
}
