package com.biqi.dto;

import java.util.Date;
import javax.validation.constraints.Size;
import com.biqi.model.validate.Login;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@ToString
@Api(value="The user logs in to the incoming object\n")
public class LoginDto {
	
	@ApiModelProperty(value = "name")
    @Size(min = 1, max = 8,message="The length of the first name must not be 2-8 characters\n",groups = {Login.class})
	private String username;
	
	@ApiModelProperty(value = "password")
    @Size(min = 1, max = 8,message="The login password is entered in the wrong length\n",groups={Login.class})
	private String password;

}
