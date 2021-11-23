package com.liu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 陆源东
 * Druid连接池配置
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(value = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }
    /*后台监控功能*/
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        /*后台登陆人员账号密码配置*/
        HashMap<String,String> initParameters = new HashMap<>();
        /*进行配置*/
        //键是固定的，不可以改变
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","admin");
        //允许谁可以访问
        initParameters.put("allow",""); //为空所有人可以 为localhost本机访问 "xxx"特定的人访问
        //禁止谁可以访问
        initParameters.put("xxx","192.168.22.123");//禁止xxx的某个ip访问
        bean.setInitParameters(initParameters); //设置初始化参数
        return bean;
    }
//    Filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        /*可以过滤的请求*/
        Map<String,String> initParameters = new HashMap<>();
        /*这些东西不进行统计*/
        initParameters.put("exclusion","*.js,*.css,/druid/");
        bean.setInitParameters(initParameters);
        return bean;
    }
}
