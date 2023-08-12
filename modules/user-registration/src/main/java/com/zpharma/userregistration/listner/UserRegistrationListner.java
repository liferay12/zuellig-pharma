package com.zpharma.userregistration.listner;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

public class UserRegistrationListner extends BaseModelListener<User> {
	@Override
    public void onAfterCreate(User user) throws ModelListenerException {
        System.out.println(
            "About to  after create user: " + user.getFullName());

    }
	@Override
    public void onAfterUpdate(User user) throws ModelListenerException {
        System.out.println(
            "About to  after update create user: " + user.getFullName());

    }


}
