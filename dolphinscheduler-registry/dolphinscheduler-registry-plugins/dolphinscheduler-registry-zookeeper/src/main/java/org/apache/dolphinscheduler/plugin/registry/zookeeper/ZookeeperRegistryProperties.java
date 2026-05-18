/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



package org.apache.dolphinscheduler.plugin.registry.zookeeper;

import java.time.Duration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "registry", name = "type", havingValue = "zookeeper")
@ConfigurationProperties(prefix = "registry")
public class ZookeeperRegistryProperties {
    private ZookeeperProperties zookeeper = new ZookeeperProperties();

    public ZookeeperProperties getZookeeper() {
        return zookeeper;
    }

    public void setZookeeper(ZookeeperProperties zookeeper) {
        this.zookeeper = zookeeper;
    }

    public static final class ZookeeperProperties {
        private String namespace;
        private String connectString;
        private RetryPolicy retryPolicy = new RetryPolicy();
        private String digest;
        private Duration sessionTimeout = Duration.ofSeconds(30);
        private Duration connectionTimeout = Duration.ofSeconds(120);
        private Duration blockUntilConnected = Duration.ofMillis(2000);

        public Duration getMaxWaitTime() {
            return maxWaitTime;
        }

        public void setMaxWaitTime(Duration maxWaitTime) {
            this.maxWaitTime = maxWaitTime;
        }

        public int getConnectionRetryCount() {
            return connectionRetryCount;
        }

        public void setConnectionRetryCount(int connectionRetryCount) {
            this.connectionRetryCount = connectionRetryCount;
        }

        public Duration getRetryInterval() {
            return retryInterval;
        }

        public void setRetryInterval(Duration retryInterval) {
            this.retryInterval = retryInterval;
        }

        private Duration maxWaitTime = Duration.ofSeconds(60); // 最大等待时间
        private int connectionRetryCount = 3; // 连接重试次数

        private Duration retryInterval = Duration.ofSeconds(2); // 重试间隔

        public String getNamespace() {
            return namespace;
        }

        public void setNamespace(String namespace) {
            this.namespace = namespace;
        }

        public String getConnectString() {
            return connectString;
        }

        public void setConnectString(String connectString) {
            this.connectString = connectString;
        }

        public RetryPolicy getRetryPolicy() {
            return retryPolicy;
        }

        public void setRetryPolicy(RetryPolicy retryPolicy) {
            this.retryPolicy = retryPolicy;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public Duration getSessionTimeout() {
            return sessionTimeout;
        }

        public void setSessionTimeout(Duration sessionTimeout) {
            this.sessionTimeout = sessionTimeout;
        }

        public Duration getConnectionTimeout() {
            return connectionTimeout;
        }

        public void setConnectionTimeout(Duration connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
        }

        public Duration getBlockUntilConnected() {
            return blockUntilConnected;
        }

        public void setBlockUntilConnected(Duration blockUntilConnected) {
            this.blockUntilConnected = blockUntilConnected;
        }

        public static final class RetryPolicy {
            private Duration baseSleepTime = Duration.ofMillis(60);
            private int maxRetries;
            private Duration maxSleep = Duration.ofMillis(300);

            public Duration getBaseSleepTime() {
                return baseSleepTime;
            }

            public void setBaseSleepTime(Duration baseSleepTime) {
                this.baseSleepTime = baseSleepTime;
            }

            public int getMaxRetries() {
                return maxRetries;
            }

            public void setMaxRetries(int maxRetries) {
                this.maxRetries = maxRetries;
            }

            public Duration getMaxSleep() {
                return maxSleep;
            }

            public void setMaxSleep(Duration maxSleep) {
                this.maxSleep = maxSleep;
            }
        }
    }

}
