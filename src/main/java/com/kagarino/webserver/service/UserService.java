package com.kagarino.webserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kagarino.webserver.entity.Result;
import com.kagarino.webserver.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zwj
 * @since 2024-06-05
 */

public interface UserService extends IService<User> {
    Result<String> sendLogonMail(String mail);

    Result<String> createUser(String username, String password, String mail, String code);

    Result<String> login(String username, String password);

    Result<String> sendResetPasswordMail(String mail);

    Result<String> resetUserPassword(String username, String mail, String password, String code);
}
