package com.liu.mapper;

import com.liu.pojo.Contact_address_tab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 联系方式Mapper
 */
@Repository
@Mapper
public interface ContactAddressTabMapper {
    /**
     * 获取全部信息
     * @return
     */
    List<Contact_address_tab> queryAllContact_address_tabs();

    /**
     * 新增一条数据
     * @param contact_address_tab
     * @return
     */
    int addContact_address_tab(Contact_address_tab contact_address_tab);

    /**
     * 修改一条数据
     * @param contact_address_tab
     * @return
     */
    int updateContact_address_tab(Contact_address_tab contact_address_tab);

    /**
     * 删除一条数据
     * @param id
     * @return
     */
    int deleteContact_address_tab(@Param("id")String id);

    /**
     * 判断当前是否已存在了该记录
     * @param contact_address_tab
     * @return
     */

    int getCountsofContact(Contact_address_tab contact_address_tab);

    /**
     * 根据条件找符合的记录
     * @param contact
     * @return
     */
    /*根据条件找符合的记录*/
    Contact_address_tab queryContactByCond(Contact_address_tab contact);
}
