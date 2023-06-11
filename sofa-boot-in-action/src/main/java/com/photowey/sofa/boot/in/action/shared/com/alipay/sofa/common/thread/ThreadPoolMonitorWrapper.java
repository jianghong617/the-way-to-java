/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.photowey.sofa.boot.in.action.shared.com.alipay.sofa.common.thread;


import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * The monitor wrapper of the {@link ThreadPoolExecutor}
 *
 * @author huzijie
 * @version TheadPoolMonitor.java, v 0.1 2020年10月26日 4:14 下午 huzijie Exp $
 */
public class ThreadPoolMonitorWrapper {

    private final ThreadPoolExecutor threadPoolExecutor;

    private final ThreadPoolConfig threadPoolConfig;

    private final ThreadPoolStatistics threadPoolStatistics;

    private ScheduledFuture<?> scheduledFuture;

    public ThreadPoolMonitorWrapper(
            ThreadPoolExecutor threadPoolExecutor,
            ThreadPoolConfig threadPoolConfig,
            ThreadPoolStatistics threadPoolStatistics) {
        this.threadPoolExecutor = threadPoolExecutor;
        this.threadPoolConfig = threadPoolConfig;
        this.threadPoolStatistics = threadPoolStatistics;
    }

    /**
     * Start to monitor the {@link ThreadPoolExecutor}
     */
    public void startMonitor() {
        if (Boolean.FALSE.toString().equals(System.getProperty("sofa_thread_pool_logging_capability"))) {
            return;
        }
        synchronized (this) {
            if (scheduledFuture != null) {

            } else {
                scheduledFuture = ThreadPoolGovernor
                        .getInstance()
                        .getMonitorScheduler()
                        .scheduleAtFixedRate(
                                new ThreadPoolMonitorRunner(threadPoolConfig, threadPoolStatistics),
                                threadPoolConfig.getPeriod(), threadPoolConfig.getPeriod(),
                                threadPoolConfig.getTimeUnit());
            }
        }
    }

    /**
     * Stop to monitor the {@link ThreadPoolExecutor}
     */
    public void stopMonitor() {
        synchronized (this) {
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
                scheduledFuture = null;
            } else {

            }
        }
    }

    /**
     * Restart to monitor the {@link ThreadPoolExecutor}
     */
    public void restartMonitor() {
        synchronized (this) {
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            scheduledFuture = ThreadPoolGovernor
                    .getInstance()
                    .getMonitorScheduler()
                    .scheduleAtFixedRate(
                            new ThreadPoolMonitorRunner(threadPoolConfig, threadPoolStatistics),
                            threadPoolConfig.getPeriod(), threadPoolConfig.getPeriod(),
                            threadPoolConfig.getTimeUnit());
        }
    }

    /**
     * Return the origin {@link ThreadPoolExecutor}
     *
     * @return the {@link ThreadPoolExecutor}
     */
    public ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }

    /**
     * Return the {@link ThreadPoolConfig}
     *
     * @return the {@link ThreadPoolConfig}
     */
    public ThreadPoolConfig getThreadPoolConfig() {
        return threadPoolConfig;
    }

    /**
     * Return whether the monitor task is started
     *
     * @return started
     */
    public boolean isStarted() {
        return this.scheduledFuture != null;
    }
}
