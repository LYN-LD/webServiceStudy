package cn.lyn.webservice.interceptor;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.helpers.DOMUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.namespace.QName;
import java.util.List;

/**
 * @author LengYouNuan
 * @create 2021-05-24 下午3:05
 */
public class CxfInterceptor extends AbstractPhaseInterceptor<SoapMessage>{

    private static final Logger log = LogManager.getLogger(CxfInterceptor.class);

    public CxfInterceptor(String phase) {
        super(phase);
    }

    public CxfInterceptor(){
        super(Phase.PRE_PROTOCOL);
    }

    @Override
    public void handleMessage(SoapMessage message) throws Fault {
        System.out.println("=======================================");
        List<Header> headers = message.getHeaders();
        log.info(headers);
    }
}
