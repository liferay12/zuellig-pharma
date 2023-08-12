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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SiteConfig}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteConfig
 * @generated
 */
public class SiteConfigWrapper
	extends BaseModelWrapper<SiteConfig>
	implements ModelWrapper<SiteConfig>, SiteConfig {

	public SiteConfigWrapper(SiteConfig siteConfig) {
		super(siteConfig);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("siteConfigId", getSiteConfigId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put(
			"showCustomUserRegistration", getShowCustomUserRegistration());
		attributes.put("siteEmailAddress", getSiteEmailAddress());
		attributes.put("sitePhoneNumber", getSitePhoneNumber());
		attributes.put("openinghours", getOpeninghours());
		attributes.put("copyright", getCopyright());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long siteConfigId = (Long)attributes.get("siteConfigId");

		if (siteConfigId != null) {
			setSiteConfigId(siteConfigId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Boolean showCustomUserRegistration = (Boolean)attributes.get(
			"showCustomUserRegistration");

		if (showCustomUserRegistration != null) {
			setShowCustomUserRegistration(showCustomUserRegistration);
		}

		String siteEmailAddress = (String)attributes.get("siteEmailAddress");

		if (siteEmailAddress != null) {
			setSiteEmailAddress(siteEmailAddress);
		}

		Long sitePhoneNumber = (Long)attributes.get("sitePhoneNumber");

		if (sitePhoneNumber != null) {
			setSitePhoneNumber(sitePhoneNumber);
		}

		String openinghours = (String)attributes.get("openinghours");

		if (openinghours != null) {
			setOpeninghours(openinghours);
		}

		String copyright = (String)attributes.get("copyright");

		if (copyright != null) {
			setCopyright(copyright);
		}
	}

	/**
	 * Returns the company ID of this site config.
	 *
	 * @return the company ID of this site config
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the copyright of this site config.
	 *
	 * @return the copyright of this site config
	 */
	@Override
	public String getCopyright() {
		return model.getCopyright();
	}

	/**
	 * Returns the create date of this site config.
	 *
	 * @return the create date of this site config
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this site config.
	 *
	 * @return the group ID of this site config
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this site config.
	 *
	 * @return the modified date of this site config
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the openinghours of this site config.
	 *
	 * @return the openinghours of this site config
	 */
	@Override
	public String getOpeninghours() {
		return model.getOpeninghours();
	}

	/**
	 * Returns the primary key of this site config.
	 *
	 * @return the primary key of this site config
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the show custom user registration of this site config.
	 *
	 * @return the show custom user registration of this site config
	 */
	@Override
	public Boolean getShowCustomUserRegistration() {
		return model.getShowCustomUserRegistration();
	}

	/**
	 * Returns the site config ID of this site config.
	 *
	 * @return the site config ID of this site config
	 */
	@Override
	public long getSiteConfigId() {
		return model.getSiteConfigId();
	}

	/**
	 * Returns the site email address of this site config.
	 *
	 * @return the site email address of this site config
	 */
	@Override
	public String getSiteEmailAddress() {
		return model.getSiteEmailAddress();
	}

	/**
	 * Returns the site phone number of this site config.
	 *
	 * @return the site phone number of this site config
	 */
	@Override
	public long getSitePhoneNumber() {
		return model.getSitePhoneNumber();
	}

	/**
	 * Returns the user ID of this site config.
	 *
	 * @return the user ID of this site config
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this site config.
	 *
	 * @return the user name of this site config
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this site config.
	 *
	 * @return the user uuid of this site config
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this site config.
	 *
	 * @param companyId the company ID of this site config
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the copyright of this site config.
	 *
	 * @param copyright the copyright of this site config
	 */
	@Override
	public void setCopyright(String copyright) {
		model.setCopyright(copyright);
	}

	/**
	 * Sets the create date of this site config.
	 *
	 * @param createDate the create date of this site config
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this site config.
	 *
	 * @param groupId the group ID of this site config
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this site config.
	 *
	 * @param modifiedDate the modified date of this site config
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the openinghours of this site config.
	 *
	 * @param openinghours the openinghours of this site config
	 */
	@Override
	public void setOpeninghours(String openinghours) {
		model.setOpeninghours(openinghours);
	}

	/**
	 * Sets the primary key of this site config.
	 *
	 * @param primaryKey the primary key of this site config
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the show custom user registration of this site config.
	 *
	 * @param showCustomUserRegistration the show custom user registration of this site config
	 */
	@Override
	public void setShowCustomUserRegistration(
		Boolean showCustomUserRegistration) {

		model.setShowCustomUserRegistration(showCustomUserRegistration);
	}

	/**
	 * Sets the site config ID of this site config.
	 *
	 * @param siteConfigId the site config ID of this site config
	 */
	@Override
	public void setSiteConfigId(long siteConfigId) {
		model.setSiteConfigId(siteConfigId);
	}

	/**
	 * Sets the site email address of this site config.
	 *
	 * @param siteEmailAddress the site email address of this site config
	 */
	@Override
	public void setSiteEmailAddress(String siteEmailAddress) {
		model.setSiteEmailAddress(siteEmailAddress);
	}

	/**
	 * Sets the site phone number of this site config.
	 *
	 * @param sitePhoneNumber the site phone number of this site config
	 */
	@Override
	public void setSitePhoneNumber(long sitePhoneNumber) {
		model.setSitePhoneNumber(sitePhoneNumber);
	}

	/**
	 * Sets the user ID of this site config.
	 *
	 * @param userId the user ID of this site config
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this site config.
	 *
	 * @param userName the user name of this site config
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this site config.
	 *
	 * @param userUuid the user uuid of this site config
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SiteConfigWrapper wrap(SiteConfig siteConfig) {
		return new SiteConfigWrapper(siteConfig);
	}

}