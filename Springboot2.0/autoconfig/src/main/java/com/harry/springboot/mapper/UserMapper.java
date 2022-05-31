package com.harry.springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.harry.springboot.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User getUserinfoById(@Param("id") int id);
}
