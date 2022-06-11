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
package com.photowey.oauth2.authentication.jwt.model.token;

import lombok.Data;

import java.io.Serializable;

/**
 * {@code InnerToken}
 *
 * @author photowey
 * @date 2022/01/15
 * @since 1.0.0
 */
@Data
public class InnerToken implements Serializable {

    private String pp;
    private String ui;
    private String un;
    private String jti;
    private Integer ei;
    private String au;
}