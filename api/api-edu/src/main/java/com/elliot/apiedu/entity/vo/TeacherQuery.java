package com.elliot.apiedu.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "teacher查询对象",description = "讲师搜索时候使用的查询对象")
public class TeacherQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师姓名")
    private String name;

    @ApiModelProperty(value = "等级,1高级讲师  2特级讲师")
    private Integer level;

    @ApiModelProperty(value = "开始时间" ,example = "2019-01-01 10:10:10")
    private String begin;

    @ApiModelProperty(value = "结束时间" ,example = "2019-01-01 10:10:10")
    private String end;


}
