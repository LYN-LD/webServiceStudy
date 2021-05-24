package cn.lyn.webservice.serviceone;

import cn.lyn.webservice.serviceone.impl.WebServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * web service服务发布类
 * @author LengYouNuan
 * @create 2021-05-23 下午5:50
 */
public class Main {
    //jdk原生方式发布webService服务
//    public static void main(String[] args) {
//        Endpoint.publish("http://127.0.0.1:8080/webservice/sayhello",new WebServiceImpl());
//        System.out.println("发布成功");
//    }
}
