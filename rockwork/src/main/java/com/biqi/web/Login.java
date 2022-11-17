package com.biqi.web;

import com.biqi.dto.LoginDto;
import com.biqi.dto.UserDto;
import com.biqi.service.LoginService;
import com.common.result.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static com.common.check.CheckUtil.hasErrors;


@RestController
@Api(tags = {"user login Api"})
public class Login {

    @Autowired
    private LoginService loginService;

    @PostMapping("/loginOut")
    @ApiOperation(value = "Exit", notes="Exit")
    public ResultDto<Boolean> loginOut(HttpSession session, @RequestBody @Validated(value = { com.biqi.model.validate.Login.class }) LoginDto loginDto,
                                       BindingResult bindingResult) {
        hasErrors (bindingResult);
        ResultDto<Boolean> resultDto = new ResultDto<>();
        resultDto.setData(loginService.loginOut(loginDto));
        return resultDto;
    }

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "login", notes="login")
    public ResultDto<UserDto> login(HttpSession session, String username, String password) {
        LoginDto loginDto = new LoginDto();
        loginDto.setPassword(password);
        loginDto.setUsername(username);
        ResultDto<UserDto> resultDto = new ResultDto<>();
        resultDto.setData(loginService.login(session,loginDto));
        return resultDto;
    }




}
