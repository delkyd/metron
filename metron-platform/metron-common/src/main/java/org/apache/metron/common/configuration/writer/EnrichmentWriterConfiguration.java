/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.metron.common.configuration.writer;

import org.apache.metron.common.configuration.EnrichmentConfigurations;

import java.util.Map;

public class EnrichmentWriterConfiguration implements WriterConfiguration{
  private EnrichmentConfigurations config;

  public EnrichmentWriterConfiguration(EnrichmentConfigurations config) {
    this.config = config;
  }

  @Override
  public int getBatchSize(String sensorName) {
    if(config != null && config.getSensorEnrichmentConfig(sensorName) != null) {
      return config.getSensorEnrichmentConfig(sensorName).getBatchSize();
    }
    return 1;
  }

  @Override
  public String getIndex(String sensorName) {
    if(config != null && config.getSensorEnrichmentConfig(sensorName) != null) {
      return config.getSensorEnrichmentConfig(sensorName).getIndex();
    }
    return sensorName;
  }

  @Override
  public Map<String, Object> getSensorConfig(String sensorName) {
    if(config != null && config.getSensorEnrichmentConfig(sensorName) != null) {
      return config.getSensorEnrichmentConfig(sensorName).getConfiguration();
    }
    return null;
  }
  @Override
  public Map<String, Object> getGlobalConfig() {
    if(config != null) {
      return config.getGlobalConfig();
    }
    return null;
  }
}