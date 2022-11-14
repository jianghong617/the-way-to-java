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
package com.photowey.translator.listener.composite;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;
import com.intellij.openapi.project.Project;
import com.photowey.translator.constant.TranslatorConstants;
import com.photowey.translator.listener.TranslateListener;

/**
 * {@code CompositeTranslateListener}
 *
 * @author photowey
 * @date 2022/11/14
 * @since 1.0.0
 */
public class CompositeTranslateListener implements TranslateListener {

    @Override
    public void beforeTranslated(Project project) {
        Notifications.Bus.notify(new Notification("Print", TranslatorConstants.PLUGIN_NAME, "-^before^-", NotificationType.INFORMATION), project);
    }

    @Override
    public void afterTranslated(Project project) {
        Notifications.Bus.notify(new Notification("Print", TranslatorConstants.PLUGIN_NAME, "-^after^-", NotificationType.INFORMATION), project);
    }
}
