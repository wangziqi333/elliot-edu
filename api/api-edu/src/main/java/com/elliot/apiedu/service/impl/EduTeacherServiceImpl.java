package com.elliot.apiedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elliot.apiedu.entity.EduTeacher;
import com.elliot.apiedu.entity.vo.TeacherQuery;
import com.elliot.apiedu.mapper.EduTeacherMapper;
import com.elliot.apiedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author wangziqi
 * @since 2020-06-25
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void searchTeacher(Page<EduTeacher> page, TeacherQuery query) {

        QueryWrapper<EduTeacher> qw = new QueryWrapper<>();
        qw.orderByAsc("sort");

        if(StringUtils.hasText(query.getName())){
            qw.eq("name",query.getName());
        }
        if(query.getLevel()!=null){
            qw.eq("level",query.getLevel());
        }
        if(StringUtils.hasText(query.getEnd())){
            qw.le("gmt_create", query.getEnd());
        }
        if(StringUtils.hasText(query.getBegin())){
            qw.ge("gmt_create", query.getBegin());
        }
        this.page(page,qw);
    }
}
