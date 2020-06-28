package com.elliot.apiedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elliot.apiedu.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.elliot.apiedu.entity.vo.TeacherQuery;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author wangziqi
 * @since 2020-06-25
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void searchTeacher(Page<EduTeacher> page, TeacherQuery query);

}
