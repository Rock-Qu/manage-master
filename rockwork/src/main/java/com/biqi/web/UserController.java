package com.biqi.web;

import com.biqi.model.User;
import com.biqi.model.validate.Save;
import com.biqi.model.validate.Update;
import com.biqi.service.UserService;
import com.common.result.PageDto;
import com.common.result.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static com.common.check.CheckUtil.hasErrors;

@RestController
@Slf4j
@Api(tags = {"The basic class API document for user management"})
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user/save")
    @ApiOperation(value = "@Validated", notes="Validated")
	public ResultDto<Integer> saveUser(@RequestBody @Validated(value={Save.class})User user,BindingResult bindingResult){
		ResultDto<Integer> resultDto = new ResultDto<>();
		//分组数据校验校验处理，返回的处理
		hasErrors(bindingResult);
		resultDto.setData(userService.saveUser(user));
		return resultDto;
	}
	
	
	@PostMapping("/user/delete")
    @ApiOperation(value = "delete")
	public ResultDto<Boolean> deleteUser(@RequestParam Integer id){
		ResultDto<Boolean> resultDto = new ResultDto<>();
		resultDto.setData(userService.deleteUser(id));
		return resultDto;
	}
	
	
	@PostMapping("/user/update")
    @ApiOperation(value = "update")
	public ResultDto<Boolean> updateUser(@RequestBody @Validated(value={Update.class})User user,BindingResult bindingResult){
		ResultDto<Boolean> resultDto = new ResultDto<>();
		//分组数据校验校验处理，返回的处理
		hasErrors(bindingResult);
		resultDto.setData(userService.updateUser(user));
		return resultDto;
	}
	
	
	@GetMapping("/user/getUserByid")
    @ApiOperation(value = "getUserByid")
	public ResultDto<User> getUserByid(@RequestParam Integer id){
		ResultDto<User> resultDto = new ResultDto<>();
		resultDto.setData(userService.getUserByid(id));
		return resultDto;
	}
	
	
	@GetMapping("/user/list")
    @ApiOperation(value = "list")
	public ResultDto<PageDto<User>> listUser(){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.listUser());
		return resultDto;
	}
	
	@GetMapping("/user/listPage")
    @ApiOperation(value = "listPage")
	public ResultDto<PageDto<User>> listPage(@RequestParam Integer page,@RequestParam Integer size){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.listPage(page,size));
		return resultDto;
	}
	
	@GetMapping("/user/countUser")
    @ApiOperation(value = "countUser")
	public ResultDto<Integer> countUser(){
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setData(userService.countUser());
		return resultDto;
	}
	
	@GetMapping("/user/countUser2")
    @ApiOperation(value = "countUser2")
	public ResultDto<Integer> countUser2(){
		ResultDto<Integer> resultDto = new ResultDto<>();
		resultDto.setData(userService.countUser2());
		return resultDto;
	}
	
	
	@GetMapping("/user/testList")
    @ApiOperation(value = "testList")
	public ResultDto<PageDto<User>> testList(){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.testList());
		return resultDto;
	}
	
	@GetMapping("/user/testparalle")
    @ApiOperation(value = "testparalle")
	public ResultDto<PageDto<User>> testparalle(){
		ResultDto<PageDto<User>> resultDto = new ResultDto<>();
		resultDto.setData(userService.testparalle());
		return resultDto;
	}
	
	@GetMapping("/user/testLog")
    @ApiOperation(value = "testLog")
	public ResultDto<Boolean> testLog(){
		log.info("info ....");
		log.debug("debug ...");
		ResultDto<Boolean> resultDto = new ResultDto<>();
		return resultDto;
	}





}
