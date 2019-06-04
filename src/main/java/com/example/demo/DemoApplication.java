package com.example.demo;

import com.example.demo.entity.UserInfo;
import com.example.demo.utils.util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        // SpringApplication.run(DemoApplication.class, args);
        util u = new util();
        List<UserInfo> reader = u.reader();
        int i = 0;
        //System.out.println(reader.get(1).getUsername());
        while (i<reader.size()){
            System.out.println(reader.get(i).getId()+reader.get(i).getUsername());
            i++;
        }

    }
}
