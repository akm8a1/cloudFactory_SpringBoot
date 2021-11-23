package com.liu.service;

import com.liu.mapper.ContactAddressTabMapper;
import com.liu.pojo.Contact_address_tab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联系方式Service实现类
 */
@Service
public class ContactAddressTabServiceImpl implements ContactAddressTabService{
    @Autowired
    private ContactAddressTabMapper mapper;

    @Override
    public List<Contact_address_tab> queryAllContact_address_tabs() {
        return mapper.queryAllContact_address_tabs();
    }

    @Override
    public int addContact_address_tab(Contact_address_tab contact_address_tab) {
        return mapper.addContact_address_tab(contact_address_tab);
    }

    @Override
    public int updateContact_address_tab(Contact_address_tab contact_address_tab) {
        return mapper.updateContact_address_tab(contact_address_tab);
    }

    @Override
    public int deleteContact_address_tab(String id) {
        return mapper.deleteContact_address_tab(id);
    }

    @Override
    public int getCountsofContact(Contact_address_tab contact_address_tab) {
        return mapper.getCountsofContact(contact_address_tab);
    }

    @Override
    public Contact_address_tab queryContactByCond(Contact_address_tab contact) {
        return mapper.queryContactByCond(contact);
    }
}
