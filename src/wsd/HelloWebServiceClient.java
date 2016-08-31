package wsd;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class HelloWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:1212/helloServiceImpl?wsdl");
        QName qname = new QName("http://src.wsd.HelloService", "HelloServiceImplService");
        Service service = Service.create(url, qname);
        HelloService helloService = service.getPort(HelloService.class);
        System.out.println(helloService.sayHello("Students"));
    }
}
