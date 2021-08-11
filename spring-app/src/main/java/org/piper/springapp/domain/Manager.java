package org.piper.springapp.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Getter
@Setter
@ToString
@Component
public class Manager {
    private String name;
    private String position;

    @PostConstruct
    public void init() {
        System.out.println("Manager bean 初始化完毕调用");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Manager bean 即将被销毁");
    }

}
