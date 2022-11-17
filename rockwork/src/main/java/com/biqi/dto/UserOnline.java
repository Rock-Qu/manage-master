package com.biqi.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserOnline implements Serializable {

    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "id")
	private Integer id;
    
    @ApiModelProperty(value = "name")
    private String name;

    @ApiModelProperty(value = "Tel")
    private String phone;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "time")
    private Date loginTime;

    @ApiModelProperty(value = "ip")
    private String loginIp;

    @ApiModelProperty(value = "role")
    private Integer nameRole;


}
