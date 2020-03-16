package com.kostapo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.kostapo.spring.dao.UserDao;
import com.kostapo.spring.model.User;
 
 
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
 
   @Autowired
   private UserDao userDao;
 
   @Override
   public int add(User user) {
      return userDao.add(user);
   }
 
   @Override
   public User get(int id) {
      return userDao.get(id);
   }
 
   @Override
   public List<User> list() {
      return userDao.list();
   }
 
   @Override
   public void update(int id, User user) {
      userDao.update(id, user);
   }
 
   @Override
   public void delete(int id) {
      userDao.delete(id);
   }
}