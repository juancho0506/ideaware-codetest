package com.ideaware.codetest.ideawarecodetest.Exercise1.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

@Builder
@Data
public class UserEntry implements DisposableBean, InitializingBean {
    private String value;


    @Override
    public void destroy() throws Exception {
        value = null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        value = "Please provide a value for entry.";
    }

    @Override
    public String toString() {
        return "{" + value + '}';
    }
}
