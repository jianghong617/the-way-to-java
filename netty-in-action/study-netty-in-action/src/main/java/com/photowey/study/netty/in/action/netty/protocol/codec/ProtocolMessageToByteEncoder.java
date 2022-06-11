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
package com.photowey.study.netty.in.action.netty.protocol.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * {@code ProtocolMessageToByteEncoder}
 *
 * @author photowey
 * @date 2022/04/17
 * @since 1.0.0
 */
public class ProtocolMessageToByteEncoder extends MessageToByteEncoder<ByteBuf> {

    @Override
    public void encode(ChannelHandlerContext ctx, ByteBuf buffer, ByteBuf out) throws Exception {

    }
}
