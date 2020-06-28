package com.elliot.apiedu.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.elliot.apiedu.ApiEducationApplication;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@Configuration
@MapperScan("com.elliot.apiedu.mapper")
@EnableTransactionManagement
@PropertySource(value = {"classpath:customConf.properties"}, ignoreResourceNotFound = true)
public class MpConfig {

    public static Date getNow() {
        return new Date();
    }

    @Value("${mp.performance.max.time}")
    long performanceMaxTime;


    // 自动填充处理器
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        return new MetaObjectHandler() {
            // 做新增操作时触发
            @Override
            public void insertFill(MetaObject metaObject) {
                this.setFieldValByName("gmtCreate", getNow(), metaObject);
                this.setFieldValByName("gmtModified", getNow(), metaObject);
                this.setFieldValByName("deleted", 0, metaObject);
            }

            // 修改时触发
            @Override
            public void updateFill(MetaObject metaObject) {
                this.setFieldValByName("gmtModified", getNow(), metaObject);
            }
        };
    }


    // 分页插件
    @Bean
    public PaginationInterceptor pageInterceptor() {
        PaginationInterceptor it = new PaginationInterceptor();
        return it;
    }

    // 性能测试插件
//    @Bean
//    @Profile({"windows","macOs"})
//    public PerformanceInterceptor performanceInterceptor() {
//        PerformanceInterceptor it = new PerformanceInterceptor();
//        it.setFormat(true);
//        it.setMaxTime(performanceMaxTime);
//        return it;
//    }

    // 逻辑删除插件
    @Bean
    public LogicSqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }



}
