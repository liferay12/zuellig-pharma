package com.zpharma.commons.web.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.zpharma.service.SiteConfigLocalServiceUtil;

import org.osgi.service.component.annotations.Component;



@Component(immediate = true, service = ModelListener.class)
public class GroupEntryListener extends BaseModelListener<Group>{

	private static final Log LOGGER = LogFactoryUtil.getLog(Group.class.getName());
	
	@Override
	public void onAfterRemove(Group group) throws ModelListenerException{
		LOGGER.info("I'm Inside My Own Listener");
		System.out.println("I'm Listener" + group.getGroupKey() +"Group ID" + group.getGroupId());
		SiteConfigLocalServiceUtil.deleteByGroupId(group.getGroupId());
		
	}
}
