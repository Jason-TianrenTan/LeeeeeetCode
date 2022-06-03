package com.company;

import java.io.File;

public class WebConfig {

    static final File WEB_ROOT = new File("./web/");
    static final String DEFAULT_FILE = "index.html";
    static final String FILE_NOT_FOUND = "404.html";
    static final String METHOD_NOT_SUPPORTED = "not_supported.html";

    // port to listen connection
    static final int PORT = 8080;

    // verbose mode
    static final boolean verbose = true;
}
