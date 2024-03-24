package org.csu.mypetstorecms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("admin")
public class Admin {
    @TableId(type = IdType.AUTO)
    private String id;
    private String username;
    private String password;
    private String email;
    @TableField("real_name")
    private String realName;
    private String phone;
    private String address;
    private int status;
}
