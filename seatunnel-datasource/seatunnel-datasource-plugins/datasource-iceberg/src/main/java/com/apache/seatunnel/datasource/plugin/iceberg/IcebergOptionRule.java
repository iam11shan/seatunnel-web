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

package com.apache.seatunnel.datasource.plugin.iceberg;

import org.apache.seatunnel.api.configuration.Option;
import org.apache.seatunnel.api.configuration.Options;
import org.apache.seatunnel.api.configuration.util.OptionRule;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IcebergOptionRule {

    // HDFS URI of the Iceberg warehouse (also used as connection URI)
    public static final Option<String> WAREHOUSE_URI =
            Options.key("warehouse-uri")
                    .stringType()
                    .noDefaultValue()
                    .withDescription(
                            "The HDFS URI of the Iceberg warehouse, e.g., hdfs://master:9000/user/iceberg/warehouse.");

    // Name of the Iceberg database to read or write
    public static final Option<String> DATABASE =
            Options.key("database")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("The name of Iceberg database to read or write.");

    // Type of the catalog
    public static final Option<String> CATALOG_TYPE =
            Options.key("catalog-type")
                    .stringType()
                    .noDefaultValue()
                    .withDescription("The type of the catalog, e.g., 'hadoop'.");

    public static OptionRule optionRule() {
        return OptionRule.builder().required(WAREHOUSE_URI, CATALOG_TYPE).build();
    }

    public static OptionRule metadataRule() {
        return OptionRule.builder().required(DATABASE).build();
    }
}
