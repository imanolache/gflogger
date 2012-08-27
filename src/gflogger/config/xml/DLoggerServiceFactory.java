/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package gflogger.config.xml;

import gflogger.DefaultObjectFormatterFactory;
import gflogger.LoggerService;
import gflogger.ObjectFormatter;
import gflogger.appender.AppenderFactory;
import gflogger.disruptor.DLoggerServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Harald Wendel
 */
public class DLoggerServiceFactory implements LoggerServiceFactory {

	private final List<AppenderFactory> appenderFactories = new ArrayList<AppenderFactory>();

	private final String name;

	private final int count;

	private final int maxMessageSize;

	private final DefaultObjectFormatterFactory objectFormatterFactory = new DefaultObjectFormatterFactory();

	public DLoggerServiceFactory(String name, int count, int maxMessageSize) {
		this.name = name;
		this.count = count;
		this.maxMessageSize = maxMessageSize;
	}

	@Override
	public void addAppenderFactory(AppenderFactory factory) {
		appenderFactories.add(factory);
	}

	@Override
	public void addObjectFormatter(Class clazz, ObjectFormatter objectFormatter) {
		objectFormatterFactory.registerObjectFormatter(clazz, objectFormatter);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public LoggerService getLoggerService() {
		return new DLoggerServiceImpl(
				count,
				maxMessageSize,
				objectFormatterFactory,
				appenderFactories.toArray(new AppenderFactory[appenderFactories.size()]));
	}

}