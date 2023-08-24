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
package com.photowey.study.netty.in.action.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * {@code FileChannelReaderAndWriter}
 *
 * @author photowey
 * @date 2022/03/12
 * @since 1.0.0
 */
public class FileChannelReaderAndWriter {

    public void readAndWrite() {

        try (FileInputStream input = new FileInputStream("poetry.txt");
             FileOutputStream output = new FileOutputStream("poetry-read-write.txt");) {

            FileChannel inputChannel = input.getChannel();
            FileChannel outputChannel = output.getChannel();

            // FIXME
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);

            while (true) {
                /**
                 * <pre>
                 *     public Buffer clear() {
                 *         position = 0;
                 *         limit = capacity;
                 *         mark = -1;
                 *         return this;
                 *     }
                 * </pre>
                 */
                byteBuffer.clear();
                int read = inputChannel.read(byteBuffer);
                System.out.println("inputChannel.read == " + read);
                if (read == -1) {
                    break;
                }

                byteBuffer.flip();

                outputChannel.write(byteBuffer);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
