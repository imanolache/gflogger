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

package org.gflogger.appender;

import org.gflogger.Appender;
import org.gflogger.LoggerService;


/**
 * ConsoleAppenderFactory
 *
 * @author Vladimir Dolzhenko, vladimir.dolzhenko@gmail.com
 */
public class ConsoleAppenderFactory extends AbstractAppenderFactory {

	protected Appendable outputStream = System.out;

	@Override
	public Appender createAppender(Class<? extends LoggerService> loggerServiceClass) {
		preinit(loggerServiceClass);
		if (org.gflogger.base.LoggerServiceImpl.class.equals(loggerServiceClass)){
			final org.gflogger.base.appender.ConsoleAppender appender =
				new org.gflogger.base.appender.ConsoleAppender(bufferSize, multibyte, outputStream);

			appender.setLogLevel(logLevel);
			appender.setLayout(layout);
			appender.setImmediateFlush(immediateFlush);
			appender.setBufferedIOThreshold(bufferedIOThreshold);
			appender.setAwaitTimeout(awaitTimeout);
			appender.setEnabled(enabled);
			appender.setIndex(index);

			return appender;
		} else if (org.gflogger.disruptor.LoggerServiceImpl.class.equals(loggerServiceClass)){
			final org.gflogger.disruptor.appender.ConsoleAppender appender =
				new org.gflogger.disruptor.appender.ConsoleAppender(bufferSize, multibyte, outputStream);

			appender.setLogLevel(logLevel);
			appender.setLayout(layout);
			appender.setImmediateFlush(immediateFlush);
			appender.setBufferedIOThreshold(bufferedIOThreshold);
			appender.setAwaitTimeout(awaitTimeout);
			appender.setEnabled(enabled);
			appender.setIndex(index);

			return appender;
		}
		throw new IllegalArgumentException(loggerServiceClass.getName()
			+ " is unsupported type of logger service");
	}

	/*
	 * Setters'n'Getters
	 */

	public Appendable getOutputStream() {
		return this.outputStream;
	}

	public void setOutputStream(Appendable outputStream) {
		this.outputStream = outputStream;
	}

}
