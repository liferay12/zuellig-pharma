package com.zpharma.user.profile.portlet;


import com.liferay.portal.kernel.exception.PortalException;


import com.liferay.portal.kernel.model.User;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import com.liferay.portal.kernel.service.ServiceContextThreadLocal;

import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.zpharma.user.profile.constants.UserProfilePortletKeys;

import java.io.IOException;


import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { 
		"com.liferay.portlet.display-category=Zuellig Pharma",
		"com.liferay.portlet.header-portlet-css=/css/main.css", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Profile Portlet", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", 
		"javax.portlet.name=" + UserProfilePortletKeys.USERPROFILE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
		}, service = Portlet.class)
public class UserProfilePortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try {
		 
			User currentUser = PortalUtil.getUser(renderRequest);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String portraitURL = themeDisplay.getUser().getPortraitURL(themeDisplay);
			long organizationLogoId = 0;
			if(ListUtil.isNotEmpty(themeDisplay.getUser().getOrganizations())) {
				organizationLogoId = themeDisplay.getUser().getOrganizations().get(0).getLogoId();
			}
			renderRequest.setAttribute("profilePicture", portraitURL);
			renderRequest.setAttribute("currentUser", currentUser);
			renderRequest.setAttribute("organizationLogoId", organizationLogoId);

		} catch (PortalException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
}