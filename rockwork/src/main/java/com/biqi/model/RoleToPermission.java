package com.biqi.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "role_to_permission")
@Api(value="user permission")
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RoleToPermission {

    @Id
    private Integer id;

    @ApiModelProperty(value = "permissionId")
    private Integer permissionId;

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
