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
package com.photowey.minio.in.action.config;

import com.photowey.minio.in.action.property.MinIOProperties;
import io.minio.MinioAsyncClient;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * {@code MinIOAutoConfigurer}
 *
 * @author photowey
 * @date 2022/06/06
 * @since 1.0.0
 */
@Configuration
@EnableConfigurationProperties(MinIOProperties.class)
public class MinIOAutoConfigurer {

    @Autowired
    private MinIOProperties properties;

    /**
     * MinioClient
     * <p>
     * {@literal @}ConditionalOnExpression("#{'true'.equals(environment['spring.minio.sync.enabled'])}")
     *
     * @return {@link MinioClient}
     */
    @Bean
    @ConditionalOnExpression("${spring.minio.sync.enabled:true}")
    public MinioClient minioClient() {
        MinioClient.Builder builder = MinioClient.builder()
                .endpoint(properties.getEndpoint())
                .credentials(properties.getAccessKey(), properties.getSecretKey());

        if (StringUtils.hasText(properties.getRegion())) {
            builder.region(properties.getRegion());
        }

        return builder.build();

    }

    /**
     * MinioAsyncClient
     *
     * @return {@link MinioAsyncClient}
     * {@literal @}ConditionalOnExpression("#{'true'.equals(environment['spring.minio.async.enabled'])}")
     */
    @Bean
    @ConditionalOnExpression("${spring.minio.async.enabled:false}")
    public MinioAsyncClient minioAsyncClient() {
        MinioAsyncClient.Builder builder = MinioAsyncClient.builder()
                .endpoint(properties.getEndpoint())
                .credentials(properties.getAccessKey(), properties.getSecretKey());

        if (StringUtils.hasText(properties.getRegion())) {
            builder.region(properties.getRegion());
        }

        return builder.build();
    }

}
