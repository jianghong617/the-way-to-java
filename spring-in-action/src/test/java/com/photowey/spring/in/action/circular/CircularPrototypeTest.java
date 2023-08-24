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
package com.photowey.spring.in.action.circular;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * {@code CircularPrototypeTest}
 *
 * @author photowey
 * @date 2021/11/15
 * @since 1.0.0
 */
@SpringBootTest
class CircularPrototypeTest {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'circularPrototypeA':
     * Unsatisfied dependency expressed through field 'circularPrototypeB';
     * nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'circularPrototypeB':
     * Unsatisfied dependency expressed through field 'circularPrototypeA';
     * nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException: Error creating bean with name 'circularPrototypeA':
     * Requested bean is currently in creation: Is there an unresolvable circular reference?
     */
    @Test
    void testCircularPrototype() {
        Assertions.assertThrows(UnsatisfiedDependencyException.class, () -> {
            this.applicationContext.getBean(CircularPrototypeA.class);
            this.applicationContext.getBean(CircularPrototypeB.class);
        });
    }

}