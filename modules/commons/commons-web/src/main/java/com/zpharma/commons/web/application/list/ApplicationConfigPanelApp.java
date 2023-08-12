package com.zpharma.commons.web.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.zpharma.commons.web.constants.ApplicationConfigPanelCategoryKeys;
import com.zpharma.commons.web.constants.ApplicationConfigPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author Ranjeet
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + ApplicationConfigPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class ApplicationConfigPanelApp extends BasePanelApp {

		@Override
		public String getPortletId() {
			return ApplicationConfigPortletKeys.APPLICATIONCONFIG;
		}

		@Override
		@Reference(
			target = "(javax.portlet.name=" + ApplicationConfigPortletKeys.APPLICATIONCONFIG + ")",
			unbind = "-"
		)
		public void setPortlet(Portlet portlet) {
			super.setPortlet(portlet);
		}
	
}
