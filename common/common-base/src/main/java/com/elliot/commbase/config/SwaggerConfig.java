package com.elliot.commbase.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类.
 */
@Configuration
@EnableSwagger2 //开启swagger
public class SwaggerConfig {


    @Bean
    public Docket webApiConfig() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.groupName("webApi")
                // 自定义文档的主要信息
                .apiInfo(apiInfo())
                // select()返回一个ApiSelectorbuilder,用来控制哪些接口让Swagger来实现
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error/.*")))
                .build();
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("在线教育API文档")
                .description("文档描述了接口信息")
                .version("v1.0")
                .contact(new Contact("Elliot", "http://elliot.com", "wangziqi6855@163.com"))
                .build();

    }


}
