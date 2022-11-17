package com.biqi.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Api(value="The user logs in to the Dto")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable{

	private static final long serialVersionUID = -1L;
	
    @ApiModelProperty(value = "id")
	private Integer id;
	
	@ApiModelProperty(value = "name")
	private String name;
	
    @ApiModelProperty(value = "Tel")
	private String phone;
    
    @ApiModelProperty(value = "token")
	private String token;

	
}
