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
package com.photowey.rabbitmq.in.action.constant;

/**
 * {@code RabbitMqConstants}
 *
 * @author photowey
 * @date 2022/05/29
 * @since 1.0.0
 */
public interface RabbitMqConstants {

    /**
     * 默认交换机名称
     */
    String DEFAULT_EXCHANGE = "rabbitmq_default_exchange";
    /**
     * 延时队列交换机
     */
    String DELAYED_EXCHANGE = "rabbitmq_default_delayed_exchange";

    /**
     * 默认队列
     */
    String DEFAULT_QUEUE = "rabbitmq_default_queue";

    /**
     * 默认延迟队列
     */
    String DEFAULT_DELAYED_QUEUE = "rabbitmq_default_delayed_queue";

}