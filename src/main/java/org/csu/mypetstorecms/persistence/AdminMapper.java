package org.csu.mypetstorecms.persistence;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.csu.mypetstorecms.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository("adminMapper")
public interface AdminMapper extends BaseMapper<Admin> {

}
