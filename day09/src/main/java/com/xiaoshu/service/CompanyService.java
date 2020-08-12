package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.CompanyMapper;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Company;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class CompanyService {

@Autowired
private CompanyMapper companyMapper;

public Object findAll() {
	// TODO Auto-generated method stub
	return companyMapper.selectAll();
}

public Company findByName(String expressCname) {
	
	// TODO Auto-generated method stub
	Company company = new Company();
	company.setExpressCname(expressCname);
	return companyMapper.selectOne(company);
}
}
