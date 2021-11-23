package com.liu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用作前端传值的工具实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentMenuPojo {
    private String id;
    private String name;
}
