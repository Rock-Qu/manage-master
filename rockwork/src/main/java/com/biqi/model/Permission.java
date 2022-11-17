package com.biqi.model;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "permission")
@Api(value="Permissions table")
@Builder
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Permission {


    @Id
    private Integer id;

    @ApiModelProperty(value = "Permissions name")
    private String name;

    @ApiModelProperty(value = "url")
    private String url;

    @ApiModelProperty(value = "permission")
    private String permission;

    @ApiModelProperty(value = "status")
    private Integer status;

    @ApiModelProperty(value = "created date")
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
