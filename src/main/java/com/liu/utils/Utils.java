package com.liu.utils;

import java.util.Random;
import java.util.UUID;

/**
 * 工具类
 */
public class Utils {
    /**
     * 获得一个新建的UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }

    /**
     * 获取订单编号
     * @return
     */
    public static String getOrderCode() {
        String code = "ONO";
        Random random = new Random();
        for (int i=0;i<13;i++)
        {
            code+=random.nextInt(10);
        }
        return code;
    }

    /**
     * 获取设备编号
     * @return
     */
    public static String getEquipmentInfoCode() {
        String code = "EQU";
        Random random = new Random();
        for (int i=0;i<13;i++)
        {
            code+=random.nextInt(10);
        }
        return code;
    }

    /**
     * 获取产品编号
     * @return
     */
    public static String getProductCode() {
        String code = "PRO";
        Random random = new Random();
        for (int i=0;i<13;i++)
        {
            code+=random.nextInt(10);
        }
        return code;
    }

    /**
     * 超级管理员的ID
     * @return
     */
    public static String getAdminId() {
        return "5b54d9acb84d4762b2d4b0bc9a648617";
    }
}
