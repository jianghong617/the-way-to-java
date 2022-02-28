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
package com.photowey.spring.cloud.alibaba.seata.consumer.in.action.feign;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * {@code ProducerFeignClient}
 *
 * @author photowey
 * @date 2022/02/28
 * @since 1.0.0
 */
@FeignClient(name = "producer-seata-in-action")
@LoadBalancerClient(name = "producer-seata-in-action")
public interface ProducerFeignClient {

    @GetMapping("/cloud/discovery/service/instances")
    ResponseEntity<String> serviceInstances(@RequestParam("serviceName") String serviceName);
}
