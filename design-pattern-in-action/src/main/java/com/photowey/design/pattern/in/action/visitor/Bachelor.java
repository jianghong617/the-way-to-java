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
package com.photowey.design.pattern.in.action.visitor;

import java.util.List;

/**
 * {@code Bachelor}
 *
 * @author photowey
 * @date 2022/03/04
 * @since 1.0.0
 */
public class Bachelor extends Student {

    public Bachelor() {
    }

    public Bachelor(String name, String university, String rating) {
        super(name, university, rating);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(List<Visitor> visitors) {
        visitors.forEach((visitor) -> {
            visitor.visit(this);
        });
    }
}
