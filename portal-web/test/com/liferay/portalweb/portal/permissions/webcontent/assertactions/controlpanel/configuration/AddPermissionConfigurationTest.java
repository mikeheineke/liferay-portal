/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.permissions.webcontent.assertactions.controlpanel.configuration;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class AddPermissionConfigurationTest extends BaseTestCase {
	public void testAddPermissionConfiguration() throws Exception {
		int label = 1;

		while (label >= 1) {
			switch (label) {
			case 1:
				selenium.selectWindow("null");
				selenium.selectFrame("relative=top");
				selenium.open("/web/guest/home/");
				selenium.clickAt("//div[@id='dockbar']",
					RuntimeVariables.replace("Dockbar"));
				selenium.waitForElementPresent(
					"//script[contains(@src,'/aui/aui-editable/aui-editable-min.js')]");
				assertEquals(RuntimeVariables.replace("Go to"),
					selenium.getText("//li[@id='_145_mySites']/a/span"));
				selenium.mouseOver("//li[@id='_145_mySites']/a/span");
				selenium.waitForVisible("link=Control Panel");
				selenium.clickAt("link=Control Panel",
					RuntimeVariables.replace("Control Panel"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Roles", RuntimeVariables.replace("Roles"));
				selenium.waitForPageToLoad("30000");
				selenium.type("//input[@id='_128_keywords']",
					RuntimeVariables.replace("Member"));
				selenium.clickAt("//input[@value='Search']",
					RuntimeVariables.replace("Search"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Member"),
					selenium.getText("//tr[3]/td/a"));
				selenium.clickAt("//tr[3]/td/a",
					RuntimeVariables.replace("Member"));
				selenium.waitForPageToLoad("30000");
				selenium.clickAt("link=Define Permissions",
					RuntimeVariables.replace("Define Permissions"));
				selenium.waitForPageToLoad("30000");
				selenium.select("//select[@id='_128_add-permissions']",
					RuntimeVariables.replace("index=112"));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace("Web Content"),
					selenium.getText("//h3"));

				boolean webContentConfigChecked = selenium.isChecked(
						"//input[@value='15CONFIGURATION']");

				if (webContentConfigChecked) {
					label = 2;

					continue;
				}

				selenium.clickAt("//input[@value='15CONFIGURATION']",
					RuntimeVariables.replace("Configuration"));

			case 2:
				assertTrue(selenium.isChecked(
						"//input[@value='15CONFIGURATION']"));
				selenium.clickAt("//input[@value='Save']",
					RuntimeVariables.replace(""));
				selenium.waitForPageToLoad("30000");
				assertEquals(RuntimeVariables.replace(
						"The role permissions were updated."),
					selenium.getText("//div[@class='portlet-msg-success']"));
				assertEquals(RuntimeVariables.replace("Web Content"),
					selenium.getText("//tr[3]/td[1]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//tr[3]/td[2]"));
				assertEquals(RuntimeVariables.replace("Access in Control Panel"),
					selenium.getText("//tr[3]/td[3]"));
				assertEquals(RuntimeVariables.replace("Portal"),
					selenium.getText("//tr[3]/td[4]"));
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//tr[3]/td[5]/span/a"));
				assertEquals(RuntimeVariables.replace("Web Content"),
					selenium.getText("//tr[4]/td[1]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//tr[4]/td[2]"));
				assertEquals(RuntimeVariables.replace("Configuration"),
					selenium.getText("//tr[4]/td[3]"));
				assertEquals(RuntimeVariables.replace("Portal"),
					selenium.getText("//tr[4]/td[4]"));
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//tr[4]/td[5]/span/a"));
				assertEquals(RuntimeVariables.replace("Web Content"),
					selenium.getText("//tr[5]/td[1]/a"));
				assertEquals(RuntimeVariables.replace(""),
					selenium.getText("//tr[5]/td[2]"));
				assertEquals(RuntimeVariables.replace("View"),
					selenium.getText("//tr[5]/td[3]"));
				assertEquals(RuntimeVariables.replace("Portal"),
					selenium.getText("//tr[5]/td[4]"));
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//tr[5]/td[5]/span/a"));
				assertEquals(RuntimeVariables.replace("Web Content"),
					selenium.getText("//tr[6]/td[1]/a"));
				assertEquals(RuntimeVariables.replace("Web Content Management"),
					selenium.getText("//tr[6]/td[2]"));
				assertEquals(RuntimeVariables.replace("View"),
					selenium.getText("//tr[6]/td[3]"));
				assertEquals(RuntimeVariables.replace("Portal"),
					selenium.getText("//tr[6]/td[4]"));
				assertEquals(RuntimeVariables.replace("Delete"),
					selenium.getText("//tr[6]/td[5]/span/a"));

			case 100:
				label = -1;
			}
		}
	}
}