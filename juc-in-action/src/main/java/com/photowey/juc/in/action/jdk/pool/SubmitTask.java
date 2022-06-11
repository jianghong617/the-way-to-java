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
package com.photowey.juc.in.action.jdk.pool;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * {@code SubmitTask}
 *
 * @author photowey
 * @date 2021/11/30
 * @since 1.0.0
 */
@Data
@Slf4j
public class SubmitTask implements Callable<Integer> {

    private int taskNo;
    private long await;

    public SubmitTask(int taskNo) {
        this.taskNo = taskNo;
        this.await = -1L;
    }

    public SubmitTask(int taskNo, long await) {
        this.taskNo = taskNo;
        this.await = await;
    }

    @Override
    public Integer call() throws Exception {
        log.info("execute the submit-task,the task-no is:{}", taskNo);
        if (this.await > 0L) {
            TimeUnit.MILLISECONDS.sleep(await);
        }

        // return 9527;
        return taskNo;
    }
}
