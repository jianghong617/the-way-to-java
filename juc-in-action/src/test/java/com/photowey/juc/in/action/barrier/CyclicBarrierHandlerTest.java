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
package com.photowey.juc.in.action.barrier;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * {@code CyclicBarrierHandlerTest}
 *
 * @author photowey
 * @date 2021/11/29
 * @since 1.0.0
 */
class CyclicBarrierHandlerTest {

    @Test
    void testCyclicBarrier() throws InterruptedException {
        int parties = 2;
        CyclicBarrierHandler cyclicBarrierHandler = new CyclicBarrierHandler(parties);
        cyclicBarrierHandler.walk(parties);

        TimeUnit.SECONDS.sleep(15);
    }

}