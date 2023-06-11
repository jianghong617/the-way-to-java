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

/**
 * The constants for the Sofa Thread Pool
 *
 * @author <a href="mailto:guaner.zzx@alipay.com">Alaneuler</a>
 * Created on 2020/3/19
 */
public class SofaThreadPoolConstants {

    public static final String SOFA_THREAD_POOL_LOGGING_CAPABILITY = "sofa_thread_pool_logging_capability";

    public static final long DEFAULT_TASK_TIMEOUT = 30000;

    public static final long DEFAULT_PERIOD = 5000;

    public static final long DEFAULT_GOVERNOR_INTERVAL = 30;

    public static final boolean DEFAULT_GOVERNOR_LOGGER_ENABLE = false;

    public static final boolean DEFAULT_GLOBAL_MONITOR_LOGGER_ENABLE = true;

}
