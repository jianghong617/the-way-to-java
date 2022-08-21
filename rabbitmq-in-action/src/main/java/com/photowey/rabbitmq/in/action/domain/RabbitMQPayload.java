/*
 * Copyright © 2021 the original author or authors (photowey@gmail.com)
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
package com.photowey.rabbitmq.in.action.domain;

import com.photowey.rabbitmq.in.action.constant.RabbitMQConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * {@code RabbitMQPayload}
 *
 * @author photowey
 * @date 2022/05/29
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RabbitMQPayload<T> implements Serializable {

    private static final long serialVersionUID = 3890285964805460810L;

    private String exchange = RabbitMQConstants.DEFAULT_EXCHANGE;
    private String delayedExchange = RabbitMQConstants.DEFAULT_DELAYED_EXCHANGE;

    private String routingKey = RabbitMQConstants.DEFAULT_QUEUE;
    private String delayedQueue = RabbitMQConstants.DEFAULT_DELAYED_QUEUE;

    private T data;

    private long delayedTime = 300000;
    private TimeUnit timeUnit = TimeUnit.MILLISECONDS;
}