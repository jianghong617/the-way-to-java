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
package com.photowey.auto.pipeline.in.action.throttler.constant;

/**
 * {@code SendSwitch}
 *
 * @author photowey
 * @date 2022/10/23
 * @since 1.0.0
 */
public interface SendSwitch {
    boolean THROTTLER_ONLY_WATCH = true;
    boolean ENABLE_API_THROTTLER = true;
    String THROTTLER_MERGE_STRATEGY = "";
}
