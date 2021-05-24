package cn.lyn.webservice.config;

import cn.lyn.webservice.serviceone.WebServiceInterface;
import cn.lyn.webservice.serviceone.impl.WebServiceImpl;
import cn.lyn.webservice.wsdl.WebServiceImplService;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * @author LengYouNuan
 * @create 2021-05-24 下午2:19
 */
@Configuration
public class CxfConfig {

    /**
     * 此方法被注释后:wsdl访问地址为http://127.0.0.1:8080/services/user?wsdl
     * 去掉注释后：wsdl访问地址为：http://127.0.0.1:8080/soap/user?wsdl
     */
    @Bean
    public ServletRegistrationBean creatDispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/soap/*");
    }

    /**
     * 非必要项
     */
    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public WebServiceInterface getWebSer(){
        return new WebServiceImpl();
    }

    /**
     * 发布endpoint
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(),getWebSer());
        //发布地址
        endpoint.publish("/sayHello");
        return endpoint;
    }
}
