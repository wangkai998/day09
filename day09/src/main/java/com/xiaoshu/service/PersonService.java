package com.xiaoshu.service;

import java.util.List;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.PersonMapper;
import com.xiaoshu.entity.Person;
import com.xiaoshu.entity.PersonVo;

import redis.clients.jedis.Jedis;

@Service
public class PersonService {

@Autowired
private PersonMapper personMapper;
@Autowired
private JmsTemplate jmsTemplate;
@Autowired
private Destination queueTextDestination;

public PageInfo<PersonVo> findUserPage(PersonVo personVo, Integer pageNum, Integer pageSize, String ordername,
		String order) {
	// TODO Auto-generated method stub
	PageHelper.startPage(pageNum, pageSize);
	List<PersonVo>list =personMapper.findUserPage(personVo);
	return new PageInfo<>(list);
}

public void updatePerson(Person person) {
	// TODO Auto-generated method stub
	personMapper.updateByPrimaryKeySelective(person);
}

public void addPerson(Person person) {
	// TODO Auto-generated method stub
	personMapper.insert(person);
	
	Jedis jedis = new Jedis("127.0.0.1",6379);
	jedis.set(person.getExpressName(), person.getSex());
	
	jmsTemplate.convertAndSend(queueTextDestination,JSONObject.toJSONString(person));
}

public void deletePerson(int parseInt) {
	// TODO Auto-generated method stub
	personMapper.deleteByPrimaryKey(parseInt);
}

public List<PersonVo> findByEcharts() {
	// TODO Auto-generated method stub
	return personMapper.findByEcharts();
}

public List<PersonVo> findByAll(PersonVo personVo) {
	// TODO Auto-generated method stub
	return personMapper.findUserPage(personVo);
}


}
