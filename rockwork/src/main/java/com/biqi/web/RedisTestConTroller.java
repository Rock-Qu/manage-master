package com.biqi.web;

import com.biqi.dto.UserDto;
import com.biqi.service.RedisTestService;
import com.common.result.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = {"Redis test"})
public class RedisTestConTroller {


	@Autowired
	private RedisTestService redisTestService;

	@PostMapping("/redis/saveAndGet")
    @ApiOperation(value = "redis test", notes="redis test")
	public ResultDto<String> saveAndGet(@RequestParam String name) {
		ResultDto<String>  resultDto = new ResultDto<>();
		resultDto.setData(redisTestService.saveAndGet(name));
		return resultDto;
	}

	@PostMapping("/redis/saveUserByJson")
	@ApiOperation(value = "Pass in the ID and store the user information in JSON to redis", notes="Pass in the ID and store the user information in JSON to redis")
	public ResultDto<Boolean> saveUserByJson(@RequestParam Integer id) {
		ResultDto<Boolean>  resultDto = new ResultDto<>();
		resultDto.setData(redisTestService.saveUserByJson(id));
		return resultDto;
	}


	@PostMapping("/redis/saveUserBySerializer")
	@ApiOperation(value = "Pass in the ID and store the user information in JSON to redis", notes="Pass in the ID and store the user information in JSON to redis")
	public ResultDto<Boolean> saveUserBySerializer(@RequestParam Integer id) {
		ResultDto<Boolean>  resultDto = new ResultDto<>();
		resultDto.setData(redisTestService.saveUserBySerializer(id));
		return resultDto;
	}

	@PostMapping("/redis/getUserBySerializer")
	@ApiOperation(value = "传Pass in the ID and store the user information in JSON to redis", notes="Pass in the ID and store the user information in JSON to redis")
	public ResultDto<UserDto> getUserBySerializer(@RequestParam String name) {
		ResultDto<UserDto>  resultDto = new ResultDto<>();
		resultDto.setData(redisTestService.getUserBySerializer(name));
		return resultDto;
	}


}
