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
package com.photowey.plugin.xcurl.lang.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.photowey.plugin.xcurl.lang.psi.XCURLNamedElement;
import org.jetbrains.annotations.NotNull;

/**
 * {@code XCURLNamedElementImpl}
 *
 * @author photowey
 * @date 2022/11/17
 * @since 1.0.0
 */
public abstract class XCURLNamedElementImpl extends ASTWrapperPsiElement implements XCURLNamedElement {

    public XCURLNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
