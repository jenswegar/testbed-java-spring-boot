package fi.wegar.jens.testbedapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppMetadata {

    String name = "";
    String version = "";
    String hostname = "";
}
