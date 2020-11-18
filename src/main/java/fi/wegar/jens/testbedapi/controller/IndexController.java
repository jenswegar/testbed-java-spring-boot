package fi.wegar.jens.testbedapi.controller;

import fi.wegar.jens.testbedapi.model.AppMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@BasePathAwareController
@RestController
public class IndexController {

    @Value("${spring.application.name}")
    protected String appName;

    @Value("${build.version}")
    protected String appVersion;

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public AppMetadata index(){

        String hostname;

        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "[unresolved]";
        }
        return new AppMetadata(appName, appVersion, hostname);

    }
}
