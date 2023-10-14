/*
 * Copyright 2023 Thomson Reuters/ONESOURCE. All rights reserved.
 */
package com.app;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
@Getter
@Setter
public class ConProp {

    private String tokenURL;

    @Value("${className}")
    private String className;

}
