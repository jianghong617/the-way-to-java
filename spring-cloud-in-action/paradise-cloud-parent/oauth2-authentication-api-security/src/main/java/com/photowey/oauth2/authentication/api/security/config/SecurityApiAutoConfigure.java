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
package com.photowey.oauth2.authentication.api.security.config;

import com.photowey.oauth2.authentication.api.security.authenticate.filter.GlobalAuthenticationFilter;
import com.photowey.oauth2.authentication.api.security.feign.FeignRequestInterceptor;
import com.photowey.oauth2.authentication.api.security.interceptor.ServiceAuthorityInterceptor;
import com.photowey.oauth2.authentication.api.security.manager.ServiceAuthorityManager;
import com.photowey.oauth2.authentication.api.security.mapping.RequestMappingHandlerMappingExt;
import com.photowey.oauth2.authentication.api.security.resolver.AuthUserArgumentResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@code SecurityApiAutoConfigure}
 *
 * @author photowey
 * @date 2022/01/29
 * @since 1.0.0
 */
@Configuration
public class SecurityApiAutoConfigure {

    @Bean
    @ConditionalOnMissingBean
    public ServiceAuthorityManager serviceAuthorityManager() {
        return new ServiceAuthorityManager();
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestMappingHandlerMappingExt handlerMappingExt() {
        return new RequestMappingHandlerMappingExt();
    }

    @Bean
    @ConditionalOnMissingBean
    public GlobalAuthenticationFilter authenticationFilter() {
        return new GlobalAuthenticationFilter(this.handlerMappingExt(), this.serviceAuthorityManager());
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthUserArgumentResolver securityUserArgumentResolver() {
        return new AuthUserArgumentResolver();
    }

    @Bean
    @ConditionalOnMissingBean
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor(this.serviceAuthorityManager());
    }

    @Bean
    @ConditionalOnMissingBean
    public ServiceAuthorityInterceptor serviceAuthorityInterceptor() {
        return new ServiceAuthorityInterceptor(this.serviceAuthorityManager());
    }

}
