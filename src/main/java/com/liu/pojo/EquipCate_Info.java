package com.liu.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;
import java.util.Date;
import java.util.List;

/**
 * 用做前端传值的实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipCate_Info {
    private String id;
    private String name;
    private List<EquipmentMenuPojo> equipmentMenuPojos;
}
