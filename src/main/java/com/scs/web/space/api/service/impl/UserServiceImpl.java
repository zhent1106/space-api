package com.scs.web.space.api.service.impl;

import com.scs.web.space.api.domain.dto.UserDto;
import com.scs.web.space.api.domain.entity.User;
import com.scs.web.space.api.mapper.UserMapper;
import com.scs.web.space.api.service.UserService;
import com.scs.web.space.api.util.Result;
import com.scs.web.space.api.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/12/1
 **/
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public Result signUp(UserDto dto) {
        User user;
        try {
            user = userMapper.findUserByMobile(dto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
            return Result.failure(ResultCode.USER_SIGN_UP_FAIL);
        }
        //用户手机号已经存在
        if (user != null) {
            return Result.failure(ResultCode.USER_HAS_EXISTED);
        } else {
            try {
                User user1 = new User();
                user1.setMobile(dto.getMobile());
                user1.setPassword(dto.getPassword());
                user1.setNickname("新用户");
                user1.setAvatar("https://www.jianshu.com/u/822585e5c69a");
                user1.setCreateTime(LocalDateTime.now());
                userMapper.insertUser(user1);
            } catch (SQLException e) {
                logger.error("新增用户出现异常");
                return Result.failure(ResultCode.USER_SIGN_UP_FAIL);
            }
        }
        return Result.success();
    }
}