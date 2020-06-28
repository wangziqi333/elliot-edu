package com.elliot.apiedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.elliot.apiedu.entity.EduTeacher;
import com.elliot.apiedu.entity.vo.TeacherQuery;
import com.elliot.apiedu.service.EduTeacherService;
import com.elliot.commutils.util.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * <p> 讲师 前端控制器 </p>
 *
 * @author wangziqi
 * 
 * @since 2020-06-25
 */
@Api(description = "讲师管理")
@RestController
@RequestMapping("/apiedu/edu-teacher")
@CrossOrigin // 支持跨域
public class EduTeacherController {

  @Autowired
  private EduTeacherService teacherService;


  // @ApiResponse(code = 200, message = "返回内容")
  @ApiOperation(value = "列出所有讲师")
  @GetMapping("list")
  public Resp listAll() {
    List<EduTeacher> list = teacherService.list(null);
    return Resp.ok().data(list);
  }


  @ApiOperation("根据id删除讲师")
  @DeleteMapping("{id}")
  public Resp removeById(
      @ApiParam(name = "id", value = "讲师的Id", required = true) @PathVariable("id") String id) {
    boolean success = teacherService.removeById(id);
    if (success) {
      return Resp.ok();
    }
    return Resp.error();

  }

  @ApiOperation(value = "分页讲师列表")
  @GetMapping("{cpage}/{limit}")
  public Resp pageList(
      @ApiParam(value = "当前页", name = "cpage", required = true) @PathVariable("cpage") int cpage,
      @ApiParam(value = "每页条数", name = "limit", required = true) @PathVariable("limit") int limit,
      @ApiParam(value = "tearcherQuery", name = "查询对象") TeacherQuery q) {
    Resp r = Resp.ok();

    Page<EduTeacher> page = new Page<>(cpage, limit);

    // teacherService.page(page,null);

    teacherService.searchTeacher(page, q);

    long total = page.getTotal();
    List<EduTeacher> records = page.getRecords();

    Map data = r.data();
    data.put("total", total);
    data.put("rows", records);
    return r;
  }

  @ApiOperation(value = "新增讲师")
  @PostMapping
  public Resp insert(
      @ApiParam(value = "teacherObj", name = "新增对象") @RequestBody EduTeacher teacher) {
    teacherService.save(teacher);
    return Resp.ok();
  }


  @ApiOperation(value = "根据id查询讲师")
  // @ApiImplicitParam(paramType="path", name = "id", value = "讲师ID", required = true, dataType =
  // "String")
  @GetMapping("{id}")
  public Resp getById(@ApiParam(value = "讲师ID", name = "id") @PathVariable("id") String id) {
    EduTeacher teacher = teacherService.getById(id);
    return Resp.ok().data(teacher);
  }

  @ApiOperation(value = "根据id修改讲师")
  @PutMapping("{id}")
  public Resp updateById(@ApiParam(value = "讲师Id", name = "id") @PathVariable("id") String id,
      @ApiParam(value = "id", name = "讲师对象") @RequestBody EduTeacher teacher) {
    teacher.setId(id);
    System.out.println(id);
    teacherService.updateById(teacher);
    return Resp.ok();
  }


}

