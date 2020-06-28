package com.elliot.apiedu.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author wangziqi
 * @since 2020-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="EduTeacher对象", description="讲师")
public class EduTeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师ID")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private String id;

    @ApiModelProperty(value = "讲师姓名", example = "高秘境")
    private String name;

    @ApiModelProperty(value = "讲师简介", example = "该老师从事于java架构师25年，专注研究分布式开发框架")
    private String intro;

    @ApiModelProperty(value = "讲师资历,一句话说明讲师",example = "首席讲师")
    private String career;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师",example = "1")
    private Integer level;

    @ApiModelProperty(value = "讲师头像", example = "http://www.duoduome.com/abc.png")
    private String avatar;

    @ApiModelProperty(value = "排序", example = "2")
    private Integer sort;

    @TableLogic
    @TableField(value = "is_deleted",fill = FieldFill.INSERT)
    @ApiModelProperty(value = "逻辑删除 1（true）已删除， 0（false）未删除",example = "0")
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间", example = "2019-10-31 03:18:46")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间", example = "2019-10-31 03:18:46")
    private Date gmtModified;


}
