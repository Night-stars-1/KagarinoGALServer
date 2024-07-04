package com.kagarino.webserver.controller;


import com.kagarino.webserver.entity.Result;
import com.kagarino.webserver.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zwj
 * @since 2024-06-05
 */
@Tag(name = "用户模块", description = "用户管理测试")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @Auther: zwj
     * @Date: 2024/6/5 21:56
     * @Description: TODO 注册
     * @Params: 用户名 用户密码 用户邮箱 验证码
     * @Return: 成功与否及提示
     */
    @Operation(summary = "用户注册", description = "用户注册")
    @PostMapping("/welcome/logon")
    public Result<String> createUser(@Parameter(name = "username", description = "用户名", required = true) String username,
                                     @Parameter(name = "password", description = "用户密码", required = true) String password,
                                     @Parameter(name = "mail", description = "用户邮箱", required = true) String mail,
                                     @Parameter(name = "code", description = "验证码", required = true) String code) {
        return userService.createUser(username, password, mail, code);
    }

    /**
     * @Auther: zwj
     * @Date: 2024/6/10 15:52
     * @Description: TODO 发送邮箱验证码
     * @Params: 用户邮箱
     * @Return: 成功与否及提示
     */
    @GetMapping("/welcome/logon")
    public Result<String> verifyMail(String mail) {
        return userService.sendLogonMail(mail);
    }

    /**
     * @Auther: zwj
     * @Date: 2024/6/10 15:59
     * @Description: TODO 登录功能
     * @Params: 用户名 密码
     * @Return: 成功与否及提示
     */
    @PutMapping("/welcome/login")
    public Result<String> login(String username, String password) {
        return userService.login(username, password);
    }

    /**
     * @Auther: zwj
     * @Date: 2024/6/10 21:29
     * @Description: TODO 重置密码
     * @Params: 用户名 用户邮箱 新密码 验证码
     * @Return: 成功与否及提示
     */
    @PutMapping("/welcome/reset")
    public Result<String> resetUserPassword(String username, String mail, String password, String code) {
        return userService.resetUserPassword(username, mail, password, code);
    }

    /**
     * @Auther: zwj
     * @Date: 2024/6/10 15:52
     * @Description: TODO 发送重置密码邮箱验证码
     * @Params: 用户邮箱
     * @Return: 成功与否及提示
     */
    @GetMapping("/welcome/reset")
    public Result<String> resetMail(String mail) {
        return userService.sendResetPasswordMail(mail);
    }
}

