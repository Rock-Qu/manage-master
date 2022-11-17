package com.biqi.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "user_to_role")
@Api(value="Table of roles and permissions")
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserToRole {

    @Id
    private Integer id;

    @ApiModelProperty(value = "userId")
    private Integer userId;

    @ApiModelProperty(value = "roleId")
    private Integer roleId;

    @ApiModelProperty(value = "status")
    private Integer status;

    @ApiModelProperty(value = "created")
    private Date created;

    @ApiModelProperty(value = "createby")
    private Integer createby;

    @ApiModelProperty(value = "updated")
    private Date updated;

    @ApiModelProperty(value = "updateby")
    private Integer updateby;

    @ApiModelProperty(value = "remark")
    private String remark;

}
