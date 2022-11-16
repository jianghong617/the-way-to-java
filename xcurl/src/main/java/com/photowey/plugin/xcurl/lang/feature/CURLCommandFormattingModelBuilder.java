/**
 * Copyright © 2022 the original author or authors.
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
package com.photowey.plugin.xcurl.lang.feature;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.photowey.plugin.xcurl.lang.CURLTokenSets;
import com.photowey.plugin.xcurl.lang.XCURLanguage;
import org.jetbrains.annotations.NotNull;

/**
 * {@code CURLCommandFormattingModelBuilder}
 *
 * @author photowey
 * @date 2022/11/15
 * @since 1.0.0
 */
public class CURLCommandFormattingModelBuilder implements FormattingModelBuilder {

    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        return new SpacingBuilder(settings, XCURLanguage.getInstance())
                .after(CURLTokenSets.CURL).spaces(1)
                .before(CURLTokenSets.CURL).spaces(0)
                .around(CURLTokenSets.OPTION).spaces(1)
                .around(CURLTokenSets.QUOTED_STRING).spaces(1)
                .before(CURLTokenSets.URL).spaces(1)
                .after(CURLTokenSets.URL).lineBreakInCode();
    }

    @Override
    public @NotNull
    FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();

        CURLCommandBlock curlCommandBlock = new CURLCommandBlock(formattingContext.getNode(),
                Wrap.createWrap(WrapType.NONE, false),
                Alignment.createAlignment(),
                createSpaceBuilder(codeStyleSettings));

        return FormattingModelProvider.createFormattingModelForPsiFile(
                formattingContext.getContainingFile(), curlCommandBlock, codeStyleSettings);
    }
}