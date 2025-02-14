package com.flameking.ourwechat.service.impl;

import com.flameking.ourwechat.entity.User;
import com.flameking.ourwechat.entity.UserExample;
import com.flameking.ourwechat.mapper.UserMapper;
import com.flameking.ourwechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 根据微信id查询user
    @Override
    public User getUserByWexinId(String wexinId){
        // 构建查询条件
        UserExample example = new UserExample();
        example.createCriteria().andWexinIdEqualTo(wexinId);

        List<User> users = userMapper.selectByExample(example);

        if(users.size() == 0){
            return null;
        }
        return users.get(0);
    }

    // 根据email查询user
    @Override
    public User getUserByEmail(String email) {
        // 构建查询条件
        UserExample example = new UserExample();
        example.createCriteria().andEmailEqualTo(email);

        List<User> users = userMapper.selectByExample(example);

        if(users.size() == 0){
            return null;
        }
        return users.get(0);
    }

    // 添加user
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
}
