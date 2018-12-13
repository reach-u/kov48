package com.reach_u.kov48;

import com.reach_u.kov48.conf.Conf;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RestRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Conf.class).run(args);
    }

}
