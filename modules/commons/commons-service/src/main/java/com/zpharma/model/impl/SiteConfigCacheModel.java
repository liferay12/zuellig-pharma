/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.zpharma.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.zpharma.model.SiteConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SiteConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SiteConfigCacheModel
	implements CacheModel<SiteConfig>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SiteConfigCacheModel)) {
			return false;
		}

		SiteConfigCacheModel siteConfigCacheModel =
			(SiteConfigCacheModel)object;

		if (siteConfigId == siteConfigCacheModel.siteConfigId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, siteConfigId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{siteConfigId=");
		sb.append(siteConfigId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", showCustomUserRegistration=");
		sb.append(showCustomUserRegistration);
		sb.append(", siteEmailAddress=");
		sb.append(siteEmailAddress);
		sb.append(", sitePhoneNumber=");
		sb.append(sitePhoneNumber);
		sb.append(", openinghours=");
		sb.append(openinghours);
		sb.append(", copyright=");
		sb.append(copyright);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SiteConfig toEntityModel() {
		SiteConfigImpl siteConfigImpl = new SiteConfigImpl();

		siteConfigImpl.setSiteConfigId(siteConfigId);
		siteConfigImpl.setGroupId(groupId);
		siteConfigImpl.setCompanyId(companyId);
		siteConfigImpl.setUserId(userId);

		if (userName == null) {
			siteConfigImpl.setUserName("");
		}
		else {
			siteConfigImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			siteConfigImpl.setCreateDate(null);
		}
		else {
			siteConfigImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			siteConfigImpl.setModifiedDate(null);
		}
		else {
			siteConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		siteConfigImpl.setShowCustomUserRegistration(
			showCustomUserRegistration);

		if (siteEmailAddress == null) {
			siteConfigImpl.setSiteEmailAddress("");
		}
		else {
			siteConfigImpl.setSiteEmailAddress(siteEmailAddress);
		}

		siteConfigImpl.setSitePhoneNumber(sitePhoneNumber);

		if (openinghours == null) {
			siteConfigImpl.setOpeninghours("");
		}
		else {
			siteConfigImpl.setOpeninghours(openinghours);
		}

		if (copyright == null) {
			siteConfigImpl.setCopyright("");
		}
		else {
			siteConfigImpl.setCopyright(copyright);
		}

		siteConfigImpl.resetOriginalValues();

		return siteConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		siteConfigId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		showCustomUserRegistration = objectInput.readBoolean();
		siteEmailAddress = objectInput.readUTF();

		sitePhoneNumber = objectInput.readLong();
		openinghours = objectInput.readUTF();
		copyright = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(siteConfigId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeBoolean(showCustomUserRegistration);

		if (siteEmailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(siteEmailAddress);
		}

		objectOutput.writeLong(sitePhoneNumber);

		if (openinghours == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(openinghours);
		}

		if (copyright == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(copyright);
		}
	}

	public long siteConfigId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean showCustomUserRegistration;
	public String siteEmailAddress;
	public long sitePhoneNumber;
	public String openinghours;
	public String copyright;

}