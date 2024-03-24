package org.csu.mypetstorecms;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.mypetstorecms.entity.Admin;
import org.csu.mypetstorecms.persistence.AdminMapper;
import org.csu.mypetstorecms.service.AdminService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("org.csu.mypetstorecms.persistence")
class MyPetStoreCmsApplicationTests {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;
    @Test
    void contextLoads() {
    }

    @Test
    void adminTest(){
        Admin admin=new Admin();
        admin.setUsername("cba");
        admin.setPassword("321");
        admin.setEmail("321@csu.edu.cn");
        admin.setAddress("csu.railwayCampus");
        admin.setPhone("12312312312");
        admin.setRealName("lisi");
        admin.setStatus(0);

        int result = adminService.insertAdmin(admin);
        if (result!=0) {
            System.out.println("insert successful");
        }
        else {
            System.out.println("insert failed");
        }


    }

    @Test
    void testLogin(){
        String username = "abc";
        String password = "123";

        Admin admin = adminService.getAdminByUsernameAndPassword(username, password);
        if(admin==null){
            System.out.println("login failed");
        }
        else {
            System.out.println("login successful");
            System.out.println(admin);
        }

    }

}
