/*
 * Copyright © 2021 photowey (photowey@gmail.com)
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
package com.photowey.mybatis.in.action.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.photowey.mybatis.in.action.domain.entity.Organization;

/**
 * {@code OrganizationService} Service
 *
 * @author photowey
 * @date 2021/11/12
 * @since 1.0.0
 */
public interface OrganizationService extends IService<Organization> {

    void handleRequiredSave();

    void handleNestedSave();

}
