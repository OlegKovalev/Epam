package wsd;

import javax.xml.ws.Endpoint;

public class ServiceStarter {
    public static void main(String[] args) {
        String url = "http://localhost:1212/hello";
        Endpoint.publish(url, new HelloServiceImpl());
        System.out.println("Service started @ " + url);
    }
}
