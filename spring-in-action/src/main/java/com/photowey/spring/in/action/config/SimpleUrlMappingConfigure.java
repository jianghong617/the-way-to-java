/*
 * Copyright © 2021 photowey (photowey@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photowey.spring.in.action.config;

import com.photowey.spring.in.action.controller.HelloHttpRequestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

/**
 * {@code SimpleUrlMappingConfigure}
 *
 * @author photowey
 * @date 2021/11/12
 * @since 1.0.0
 */
@Configuration
public class SimpleUrlMappingConfigure {

    @Bean
    public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
        SimpleUrlHandlerMapping suhm = new SimpleUrlHandlerMapping();

        Properties properties = new Properties();
        properties.put("/hello/http/request/handler", this.helloHttpRequestHandler());
        suhm.setMappings(properties);

        return suhm;
    }

    @Bean
    public HttpRequestHandler helloHttpRequestHandler() {
        return new HelloHttpRequestHandler();
    }

}