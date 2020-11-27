package fi.wegar.jens.testbedapi.controller;

import fi.wegar.jens.testbedapi.api.AppMetadataApi;
import fi.wegar.jens.testbedapi.model.AppMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@BasePathAwareController
@RestController
public class AppMetadataController implements AppMetadataApi {

    @Value("${spring.application.name}")
    protected String appName;

    @Value("${build.version}")
    protected String appVersion;

    public ResponseEntity<AppMetadata> appMetadata(){

        String hostname;

        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            hostname = "[unresolved]";
        }

        return ResponseEntity.ok().body(
                new AppMetadata()
                        .version(appVersion)
                        .hostname(hostname)
                        .name(appName)
        );
    }
}
