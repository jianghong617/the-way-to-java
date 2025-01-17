/*
 * Copyright © 2021 the original author or authors.
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
package com.photowey.jvm.delayed.queue.in.action.listener;

import com.photowey.jvm.delayed.queue.in.action.event.DelayedEvent;

/**
 * {@code DelayedQueueListener}
 *
 * @author weichangjun
 * @date 2023/01/14
 * @since 1.0.0
 */
public interface DelayedQueueListener<E extends DelayedEvent> {

    /**
     * 获取 {@code Event 类型}
     * 本来: 通过反射也可以实现, 推荐还是采用显式指定较好
     *
     * @return {@link Class<E>}
     */
    Class<E> getEvent();

    /**
     * 处理时间
     *
     * @param event {@link DelayedEvent} 自己感兴趣的事件
     */
    void onEvent(E event);
}
