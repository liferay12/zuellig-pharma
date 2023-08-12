package com.zpharma.commons.web.commands;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.zpharma.commons.web.constants.ApplicationConfigPortletKeys;
import com.zpharma.commons.web.constants.MVCCommandName;
import com.zpharma.model.SiteConfig;
import com.zpharma.model.impl.SiteConfigImpl;
import com.zpharma.service.SiteConfigLocalServiceUtil;

import org.osgi.service.component.annotations.Component;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;


@Component(immediate = true, property = { "javax.portlet.name=" + ApplicationConfigPortletKeys.APPLICATIONCONFIG,
		"mvc.command.name=" + MVCCommandName.SAVE_SITECONFIG }, service = MVCActionCommand.class)
public class SaveSiteConfigActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		Long siteConfigId = ParamUtil.getLong(actionRequest, "siteConfigId");
		Boolean showCustomUserRegistration = ParamUtil.getBoolean(actionRequest, "showCustomUserRegistration");
		String siteEmailAddress = ParamUtil.getString(actionRequest, "siteEmailAddress");
		Long sitePhoneNumber = ParamUtil.getLong(actionRequest, "sitePhoneNumber");
		String openinghours = ParamUtil.getString(actionRequest, "openinghours");
		String copyright = ParamUtil.getString(actionRequest, "copyright");
		
		SiteConfig siteConfig = null;
		if(siteConfigId!=0) {
			siteConfig = SiteConfigLocalServiceUtil.getSiteConfig(siteConfigId);
			siteConfig.setShowCustomUserRegistration(showCustomUserRegistration);
			siteConfig.setSiteEmailAddress(siteEmailAddress);
			siteConfig.setSitePhoneNumber(sitePhoneNumber);
			siteConfig.setOpeninghours(openinghours);
			siteConfig.setCopyright(copyright);
			
		}else {
			siteConfig = SiteConfigLocalServiceUtil.createSiteConfig(CounterLocalServiceUtil.increment());
			siteConfig.setShowCustomUserRegistration(showCustomUserRegistration);
			siteConfig.setSiteEmailAddress(siteEmailAddress);
			siteConfig.setSitePhoneNumber(sitePhoneNumber);
			siteConfig.setOpeninghours(openinghours);
			siteConfig.setCopyright(copyright);
			
		}
		SiteConfigLocalServiceUtil.saveOrUpdateSiteConfiguration(siteConfig);
	}

	
}
