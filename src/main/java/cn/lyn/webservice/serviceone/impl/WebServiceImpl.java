package cn.lyn.webservice.serviceone.impl;

import cn.lyn.webservice.serviceone.WebServiceInterface;

import javax.jws.WebService;

/**
 * @author LengYouNuan
 * @create 2021-05-23 下午7:17
 */
@WebService
public class WebServiceImpl implements WebServiceInterface {
    public String sayHello(String name) {
        System.out.println(name+" say hello");
        return name+" say hello";
    }
}
