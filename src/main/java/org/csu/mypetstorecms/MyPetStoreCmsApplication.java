package org.csu.mypetstorecms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.csu.mypetstorecms.persistence")
public class MyPetStoreCmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPetStoreCmsApplication.class, args);
    }

}
