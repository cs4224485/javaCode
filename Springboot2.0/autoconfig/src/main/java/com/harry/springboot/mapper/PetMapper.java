package com.harry.springboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.harry.springboot.bean.Pet;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PetMapper extends BaseMapper<Pet> {
    Pet getPetById(int id);
}
