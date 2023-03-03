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
package com.photowey.commom.in.action.util;

/**
 * {@code HardwareUtils}
 *
 * @author photowey
 * @date 2023/03/03
 * @since 1.0.0
 */
public final class HardwareUtils {

    private static final int NCPU = Runtime.getRuntime().availableProcessors();

    private HardwareUtils() {
        // utility class; can't create
        throw new AssertionError("No " + this.getClass().getName() + " instances for you!");
    }

    public static int getNcpu() {
        return NCPU;
    }

    public static int getDoubleNcpu() {
        return NCPU << 1;
    }
}
