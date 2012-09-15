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
package org.gflogger.perftest;

import org.gflogger.GFLog;
import org.gflogger.GFLogFactory;
import org.gflogger.config.xml.XmlLogFactoryConfigurator;



/**
 * XmlConfigurationTest
 *
 * @author Vladimir Dolzhenko, vladimir.dolzhenko@gmail.com
 */
public class XmlConfigurationTest {

	public static void main(String[] args) throws Exception {
		XmlLogFactoryConfigurator.configure();

		final GFLog logger = GFLogFactory.getLog("com.db.fxpricing.Logger");

		logger.info().
			append(new SomeObject(5)).commit();

		logger.info().append("test1").commit();

		logger.debug().append("testD").commit();

		logger.error().append("testE").commit();

		logger.info().append("test2").commit();

		logger.info().append("test3").commit();

		final GFLog logger2 = GFLogFactory.getLog("org.spring");

		logger2.info().append("org.spring.info").commit();

		logger2.debug().append("org.spring.debug").commit();

		logger2.error().append("org.spring.error").commit();

		GFLogFactory.stop();
	}
}