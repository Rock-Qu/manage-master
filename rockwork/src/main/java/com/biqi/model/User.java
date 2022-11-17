package com.biqi.model;

import com.biqi.model.validate.Save;
import com.biqi.model.validate.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Range;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Builder
@Data
@Table(name = "User")
@Api(value="user table")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@NotNull(message="The user's update must pass in the id\n",groups={Update.class})
	private Integer id;

    @ApiModelProperty(value = "name",required = true)
    @Size(min = 2, max = 8,message="The length of the first name must not be 2-8 characters\n",groups = {Save.class, Update.class})
	private String name;

    @ApiModelProperty(value = "password")
    @Size(min = 6, max = 8,message="The length of the user's new password is 6-8\n",groups={Save.class})
    @Size(min = 8, max = 10,message="The user's update password length is 8-10\n",groups={Update.class})
	private String password;

    @ApiModelProperty(value = "Tel")
	@Pattern(regexp="^(13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])\\d{8}$",message="The phone number format is incorrect\n",groups = {Save.class, Update.class})
	private String phone;

    @ApiModelProperty(value = "1 for male, 0 for female")
    @Range(min=0,max=1,message="The gender value is wrong, which can only be 0 or ")
	private Integer sex;

    @ApiModelProperty(value = "created")
	private Date created;

    @ApiModelProperty(value = "createby")
	private Integer createby;

    @ApiModelProperty(value = "updated")
	private Date updated;

    @ApiModelProperty(value = "updateby")
	private Integer updateby;
    
    

}
