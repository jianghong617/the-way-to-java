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
package com.photowey.solr.in.action.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * {@code Area}
 *
 * @author photowey
 * @date 2022/03/20
 * @since 1.0.0
 */
@Data
@TableName("zh_cn_area")
public class Area implements Serializable {

    @TableId("id")
    private Integer id;
    @TableField("pid")
    private Integer pid;
    @TableField("short_name")
    private String shortName;
    private String name;
    @TableField("merger_name")
    private String mergerName;
    private Integer level;
    private String pinyin;
    private String code;
    @TableField("zip_code")
    private String zipCode;
    private String first;
    @TableField("lng")
    private String longitude;
    @TableField("lat")
    private String latitude;
}
