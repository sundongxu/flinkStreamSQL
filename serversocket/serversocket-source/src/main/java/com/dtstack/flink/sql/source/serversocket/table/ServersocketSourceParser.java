/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dtstack.flink.sql.source.serversocket.table;

import com.dtstack.flink.sql.table.AbsSourceParser;
import com.dtstack.flink.sql.table.TableInfo;
import com.dtstack.flink.sql.util.MathUtil;

import java.util.Map;

/**
 * Reason:
 * Date: 2018/12/18
 * Company: www.dtstack.com
 *
 * @author maqi
 */
public class ServersocketSourceParser extends AbsSourceParser {
	@Override
	public TableInfo getTableInfo(String tableName, String fieldsInfo, Map<String, Object> props) {
		ServersocketSourceTableInfo serversocketSourceTableInfo = new ServersocketSourceTableInfo();
		serversocketSourceTableInfo.setName(tableName);
		parseFieldsInfo(fieldsInfo, serversocketSourceTableInfo);

		serversocketSourceTableInfo.setHostname(MathUtil.getString(props.get(ServersocketSourceTableInfo.HOSTNAME_KEY.toLowerCase())));
		serversocketSourceTableInfo.setPort(MathUtil.getIntegerVal(props.get(ServersocketSourceTableInfo.PORT_KEY.toLowerCase())));
		serversocketSourceTableInfo.setDelimiter(MathUtil.getString(props.get(ServersocketSourceTableInfo.DELIMITER_KEY.toLowerCase())));
		serversocketSourceTableInfo.setMaxNumRetries(MathUtil.getLongVal(props.get(ServersocketSourceTableInfo.MAXNUMRETRIES_KEY.toLowerCase())));

		serversocketSourceTableInfo.check();

		return serversocketSourceTableInfo;
	}
}
