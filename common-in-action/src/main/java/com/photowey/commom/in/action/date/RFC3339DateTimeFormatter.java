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
package com.photowey.commom.in.action.date;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * {@code RFC3339DateTimeFormatter}
 *
 * @author photowey
 * @date 2023/05/23
 * @since 1.0.0
 */
public interface RFC3339DateTimeFormatter {

    static DateTimeFormatter rfc3339FormatterGMT8() {
        return rfc3339Formatter(DatePatternConstants.GMT_8);
    }

    static DateTimeFormatter rfc3339Formatter(String zone) {
        return new DateTimeFormatterBuilder()
                .parseCaseInsensitive()
                .append(DateTimeFormatter.ISO_LOCAL_DATE)
                .appendLiteral(DatePatternConstants.RFC_3339_T)
                .append(DateTimeFormatter.ISO_LOCAL_TIME)
                .appendLiteral(zone)
                .toFormatter();
    }

}
