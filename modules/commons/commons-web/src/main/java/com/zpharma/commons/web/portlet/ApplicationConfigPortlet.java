package com.zpharma.commons.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.zpharma.commons.web.constants.ApplicationConfigPortletKeys;
import com.zpharma.model.SiteConfig;
import com.zpharma.service.SiteConfigLocalServiceUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Ranjeet
 */
@Component(immediate = true, property = { 
		"com.liferay.portlet.add-default-resource=true",
		"com.liferay.portlet.display-category=category.hidden", 
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.layout-cacheable=true", 
		"com.liferay.portlet.private-request-attributes=false",
		"com.liferay.portlet.private-session-attributes=false", 
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.use-default-template=true", 
		"javax.portlet.display-name=Site Config",
		"javax.portlet.expiration-cache=0", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ApplicationConfigPortletKeys.APPLICATIONCONFIG,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user",
	}, service = Portlet.class)

public class ApplicationConfigPortlet extends MVCPortlet {

	final static Log LOGGER = LogFactoryUtil.getLog(ApplicationConfigPortlet.class.getName());

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		LOGGER.info("Inside doview");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		LOGGER.info(themeDisplay.getLayout().getGroupId());
		SiteConfig siteConfig = null;
		siteConfig = SiteConfigLocalServiceUtil.getSiteConfig(themeDisplay.getLayout().getGroup());

		LOGGER.info(siteConfig);

		renderRequest.setAttribute("siteConfig", siteConfig);
		super.doView(renderRequest, renderResponse);
	}
}
