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
package com.photowey.jvm.delayed.queue.in.action.publisher;

import com.photowey.jvm.delayed.queue.in.action.event.DelayedEvent;

import java.util.concurrent.DelayQueue;

/**
 * {@code DefaultDelayedQueueEventPublisher}
 *
 * @author weichangjun
 * @date 2023/01/14
 * @since 1.0.0
 */
public class DefaultDelayedQueueEventPublisher implements DelayedQueueEventPublisher {

    private final DelayQueue<DelayedEvent> delayQueue;

    public DefaultDelayedQueueEventPublisher(DelayQueue<DelayedEvent> delayQueue) {
        this.delayQueue = delayQueue;
    }

    @Override
    public <E extends DelayedEvent> void publishEvent(E event) {
        this.delayQueue.offer(event);
    }
}
