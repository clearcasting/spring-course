package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSillyMember() {
        System.out.println("ADDING SILLY MEMBER ACCOUNT TO DB ...");
        return true;
    }
}
