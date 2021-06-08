package cn.lyn.webservice.config;

import cn.lyn.webservice.interceptor.CxfInterceptor;
import cn.lyn.webservice.serviceone.WebServiceInterface;
import cn.lyn.webservice.serviceone.impl.WebServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author LengYouNuan
 * @create 2021-05-24 下午2:19
 */
@Configuration
public class CxfConfig implements WebMvcConfigurer {

    /**
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/user?wsdl
     */
    @Bean
    public ServletRegistrationBean creatDispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
    }

    /**
     * 非必要项
     * 用于打印cxf日志信息
     */
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        SpringBus springBus = new SpringBus();

        //将cxf拦截器添加到bus里
        CxfInterceptor cxfInterceptor = new CxfInterceptor();
        springBus.getInInterceptors().add(cxfInterceptor);
        return springBus;
    }

    @Bean
    public WebServiceInterface getWebSer() {
        return new WebServiceImpl();
    }

    /**
     * 发布endpoint
     */
    @Bean
    public Server endpoint() {
        //EndpointImpl endpoint = new EndpointImpl(springBus(),getWebSer());
        //发布地址
        //endpoint.publish("/sayHello");
        //return endpoint;

        /**
         * ===上边是java原生方式发布服务；下边是cxf方式发布服务  发布之后生成的wsdl文档信息有很明显的区别
         *因为我是采用soap方式作为客户端 所以只能用cxf方式发布服务
         * 如果客户端是采用http请求方式，则对发布方式没有严格要求
         *
         */
        //以下发布方式会在wsdl文档中生成对应方法和参数的标签信息
        WebServiceImpl hw = new WebServiceImpl();
        JaxWsServerFactoryBean jwsFactory = new JaxWsServerFactoryBean();
        jwsFactory.setAddress("sayHello");   //指定WebService的发布地址
        jwsFactory.setServiceClass(WebServiceInterface.class);//WebService对应的类型
        jwsFactory.setServiceBean(hw);//WebService对应的实现对象

        return jwsFactory.create();
    }

    @Bean
    public CxfInterceptor getCxfInterceptor() {
        return new CxfInterceptor();
    }
}
