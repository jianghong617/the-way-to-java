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
package com.photowey.property.bind.in.action.binder;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * {@code PopupYamlProperties}
 *
 * @author photowey
 * @date 2023/02/09
 * @since 1.0.0
 */
@Data
public class PopupYamlProperties {

    private String name;
    private Profile profiles = new Profile();

    @Data
    public static class Profile implements Serializable {
        private List<String> active;
    }

}