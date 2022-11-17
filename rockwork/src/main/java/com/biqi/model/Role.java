package com.biqi.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "role")
@Api(value="user table")
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    private Integer id;

    @ApiModelProperty(value = "roleName")
    private String roleName;

    @ApiModelProperty(value = "roleCode")
    private String roleCode;

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
