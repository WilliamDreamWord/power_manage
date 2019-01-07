package com.wewin.power_manage.configure;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: William
 * @Description: Swagger2的标准格式输出文档
 * @Date: 2018/10/20 10:20
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfigure {

    private static final String SWAGGER_SCAN_BASE_PACKAGE = "com.wewin.power_manage.controller";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("江津电力管理系统API在线文档 @Swagger2")
                .description("simple style")
                .contact(new Contact("梦话","https://www.williamyg.top","williamyg1996@gmail.com"))
                .termsOfServiceUrl("https://williamyg.top/power_manage")
                .version("1.0")
                .build();
    }

}
