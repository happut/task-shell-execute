package com.github.happut.configuration;


import com.github.happut.TaskShellExecuteApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;


/**
 * Title: ServletInitializer
 * Description: 相当于整个Web.xml
 * Company: blog.csdn.net/lu1005287365/
 * @author  L lulu
 * @version 1.0
 */
@Configuration
public class ServletInitializer extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TaskShellExecuteApplication.class);
    }


}