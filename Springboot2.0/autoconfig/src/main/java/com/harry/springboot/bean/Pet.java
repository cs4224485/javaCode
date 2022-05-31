package com.harry.springboot.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author cs1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pet implements Serializable {
    @TableId
    private Integer id;
    private String name;
}
