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

package com.zpharma.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.zpharma.service.http.SiteConfigServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SiteConfigSoap implements Serializable {

	public static SiteConfigSoap toSoapModel(SiteConfig model) {
		SiteConfigSoap soapModel = new SiteConfigSoap();

		soapModel.setSiteConfigId(model.getSiteConfigId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setShowCustomUserRegistration(
			model.getShowCustomUserRegistration());
		soapModel.setSiteEmailAddress(model.getSiteEmailAddress());
		soapModel.setSitePhoneNumber(model.getSitePhoneNumber());
		soapModel.setOpeninghours(model.getOpeninghours());
		soapModel.setCopyright(model.getCopyright());

		return soapModel;
	}

	public static SiteConfigSoap[] toSoapModels(SiteConfig[] models) {
		SiteConfigSoap[] soapModels = new SiteConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SiteConfigSoap[][] toSoapModels(SiteConfig[][] models) {
		SiteConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SiteConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SiteConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SiteConfigSoap[] toSoapModels(List<SiteConfig> models) {
		List<SiteConfigSoap> soapModels = new ArrayList<SiteConfigSoap>(
			models.size());

		for (SiteConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SiteConfigSoap[soapModels.size()]);
	}

	public SiteConfigSoap() {
	}

	public long getPrimaryKey() {
		return _siteConfigId;
	}

	public void setPrimaryKey(long pk) {
		setSiteConfigId(pk);
	}

	public long getSiteConfigId() {
		return _siteConfigId;
	}

	public void setSiteConfigId(long siteConfigId) {
		_siteConfigId = siteConfigId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public Boolean getShowCustomUserRegistration() {
		return _showCustomUserRegistration;
	}

	public void setShowCustomUserRegistration(
		Boolean showCustomUserRegistration) {

		_showCustomUserRegistration = showCustomUserRegistration;
	}

	public String getSiteEmailAddress() {
		return _siteEmailAddress;
	}

	public void setSiteEmailAddress(String siteEmailAddress) {
		_siteEmailAddress = siteEmailAddress;
	}

	public long getSitePhoneNumber() {
		return _sitePhoneNumber;
	}

	public void setSitePhoneNumber(long sitePhoneNumber) {
		_sitePhoneNumber = sitePhoneNumber;
	}

	public String getOpeninghours() {
		return _openinghours;
	}

	public void setOpeninghours(String openinghours) {
		_openinghours = openinghours;
	}

	public String getCopyright() {
		return _copyright;
	}

	public void setCopyright(String copyright) {
		_copyright = copyright;
	}

	private long _siteConfigId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Boolean _showCustomUserRegistration;
	private String _siteEmailAddress;
	private long _sitePhoneNumber;
	private String _openinghours;
	private String _copyright;

}