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
package com.photowey.commom.in.action.threadpool.scheduled;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * {@code SafeScheduledThreadPoolExecutor}
 *
 * @author photowey
 * @date 2023/07/11
 * @since 1.0.0
 */
public class SafeScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor {

    public SafeScheduledThreadPoolExecutor(int corePoolSize) {
        super(corePoolSize);
    }

    public SafeScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
    }

    public SafeScheduledThreadPoolExecutor(int corePoolSize, RejectedExecutionHandler handler) {
        super(corePoolSize, handler);
    }

    public SafeScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
        super(corePoolSize, threadFactory, handler);
    }

    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit, Consumer<Throwable> fx) {
        return super.scheduleWithFixedDelay(() -> {
            try {
                command.run();
            } catch (Throwable e) {
                fx.accept(e);
            }
        }, initialDelay, delay, unit);
    }

    public ScheduledFuture<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit, Consumer<Throwable> fx) {
        return super.scheduleAtFixedRate(() -> {
            try {
                command.run();
            } catch (Throwable e) {
                fx.accept(e);
            }
        }, initialDelay, period, unit);
    }
}