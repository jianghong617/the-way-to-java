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
package com.photowey.redis.in.action.queue.impl.pubsub;

import com.photowey.redis.in.action.engine.redis.IRedisEngine;
import com.photowey.redis.in.action.queue.event.pubsub.PubsubEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

/**
 * {@code RedisPubSubQueueSubscriber}
 *
 * @author photowey
 * @date 2021/10/29
 * @since 1.0.0
 */
@Slf4j
@Component
public class PubSubQueueSubscriber extends JedisPubSub implements IPubSubRedisQueueSubscriber {

    private final IRedisEngine redisEngine;
    private ApplicationContext applicationContext;

    public PubSubQueueSubscriber(IRedisEngine redisEngine) {
        this.redisEngine = redisEngine;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void subscribe(String... channels) {
        try (Jedis jedis = this.redisEngine.jedisEngine().jedis()) {
            jedis.subscribe(this, channels);
        }
    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        if (log.isInfoEnabled()) {
            log.info("redis pub/sub mode mq:subscribe the channel:[{}] successfully... and subscribed channels:[{}]", channel, subscribedChannels);
        }
    }

    @Override
    public void onMessage(String channel, String message) {
        if (log.isInfoEnabled()) {
            log.info("redis:pub/sub:mq consume message on channel:[{}],message is:{}", channel, message);
        }
        this.applicationContext.publishEvent(new PubsubEvent(message));
    }
}
