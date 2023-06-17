/*
 * Copyright © 2023 the original author or authors.
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
package com.photowey.wechat.sdk.core.cert;

import com.alibaba.fastjson2.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * {@code EncryptedCert}
 *
 * @author photowey
 * @date 2023/05/04
 * @since 1.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EncryptedCert implements Serializable {

    private static final long serialVersionUID = 8060339649451559767L;

    @JsonProperty("serial_no")
    @JSONField(name = "serial_no")
    private String serialNo;
    @JsonProperty("effective_time")
    @JSONField(name = "effective_time")
    private String effectiveTime;
    @JsonProperty("expire_time")
    @JSONField(name = "expire_time")
    private String expireTime;
    @JsonProperty("encrypt_certificate")
    @JSONField(name = "encrypt_certificate")
    private Certificate cert;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Certificate implements Serializable {

        private static final long serialVersionUID = 2592998876518057615L;

        @JsonProperty("algorithm")
        @JSONField(name = "algorithm")
        private String algorithm;
        @JsonProperty("nonce")
        @JSONField(name = "nonce")
        private String nonce;
        @JsonProperty("associated_data")
        @JSONField(name = "associated_data")
        private String associatedData;
        @JsonProperty("ciphertext")
        @JSONField(name = "ciphertext")
        private String ciphertext;
    }
}