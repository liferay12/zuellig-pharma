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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import com.zpharma.model.SiteConfig;
import com.zpharma.model.SiteConfigModel;
import com.zpharma.model.SiteConfigSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the SiteConfig service. Represents a row in the &quot;ZUELLIG_SiteConfig&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>SiteConfigModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SiteConfigImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SiteConfigImpl
 * @generated
 */
@JSON(strict = true)
public class SiteConfigModelImpl
	extends BaseModelImpl<SiteConfig> implements SiteConfigModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a site config model instance should use the <code>SiteConfig</code> interface instead.
	 */
	public static final String TABLE_NAME = "ZUELLIG_SiteConfig";

	public static final Object[][] TABLE_COLUMNS = {
		{"siteConfigId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"showCustomUserRegistration", Types.BOOLEAN},
		{"siteEmailAddress", Types.VARCHAR}, {"sitePhoneNumber", Types.BIGINT},
		{"openinghours", Types.VARCHAR}, {"copyright", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("siteConfigId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("showCustomUserRegistration", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("siteEmailAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("sitePhoneNumber", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("openinghours", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("copyright", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table ZUELLIG_SiteConfig (siteConfigId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,showCustomUserRegistration BOOLEAN,siteEmailAddress VARCHAR(75) null,sitePhoneNumber LONG,openinghours VARCHAR(75) null,copyright VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP = "drop table ZUELLIG_SiteConfig";

	public static final String ORDER_BY_JPQL =
		" ORDER BY siteConfig.siteConfigId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY ZUELLIG_SiteConfig.siteConfigId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long GROUPID_COLUMN_BITMASK = 1L;

	public static final long SITECONFIGID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static SiteConfig toModel(SiteConfigSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SiteConfig model = new SiteConfigImpl();

		model.setSiteConfigId(soapModel.getSiteConfigId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setShowCustomUserRegistration(
			soapModel.getShowCustomUserRegistration());
		model.setSiteEmailAddress(soapModel.getSiteEmailAddress());
		model.setSitePhoneNumber(soapModel.getSitePhoneNumber());
		model.setOpeninghours(soapModel.getOpeninghours());
		model.setCopyright(soapModel.getCopyright());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<SiteConfig> toModels(SiteConfigSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SiteConfig> models = new ArrayList<SiteConfig>(soapModels.length);

		for (SiteConfigSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SiteConfigModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _siteConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSiteConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _siteConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SiteConfig.class;
	}

	@Override
	public String getModelClassName() {
		return SiteConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SiteConfig, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SiteConfig, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SiteConfig, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((SiteConfig)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SiteConfig, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SiteConfig, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SiteConfig)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SiteConfig, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SiteConfig, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, SiteConfig>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			SiteConfig.class.getClassLoader(), SiteConfig.class,
			ModelWrapper.class);

		try {
			Constructor<SiteConfig> constructor =
				(Constructor<SiteConfig>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<SiteConfig, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SiteConfig, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SiteConfig, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SiteConfig, Object>>();
		Map<String, BiConsumer<SiteConfig, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SiteConfig, ?>>();

		attributeGetterFunctions.put(
			"siteConfigId", SiteConfig::getSiteConfigId);
		attributeSetterBiConsumers.put(
			"siteConfigId",
			(BiConsumer<SiteConfig, Long>)SiteConfig::setSiteConfigId);
		attributeGetterFunctions.put("groupId", SiteConfig::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId", (BiConsumer<SiteConfig, Long>)SiteConfig::setGroupId);
		attributeGetterFunctions.put("companyId", SiteConfig::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SiteConfig, Long>)SiteConfig::setCompanyId);
		attributeGetterFunctions.put("userId", SiteConfig::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<SiteConfig, Long>)SiteConfig::setUserId);
		attributeGetterFunctions.put("userName", SiteConfig::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SiteConfig, String>)SiteConfig::setUserName);
		attributeGetterFunctions.put("createDate", SiteConfig::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SiteConfig, Date>)SiteConfig::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SiteConfig::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SiteConfig, Date>)SiteConfig::setModifiedDate);
		attributeGetterFunctions.put(
			"showCustomUserRegistration",
			SiteConfig::getShowCustomUserRegistration);
		attributeSetterBiConsumers.put(
			"showCustomUserRegistration",
			(BiConsumer<SiteConfig, Boolean>)
				SiteConfig::setShowCustomUserRegistration);
		attributeGetterFunctions.put(
			"siteEmailAddress", SiteConfig::getSiteEmailAddress);
		attributeSetterBiConsumers.put(
			"siteEmailAddress",
			(BiConsumer<SiteConfig, String>)SiteConfig::setSiteEmailAddress);
		attributeGetterFunctions.put(
			"sitePhoneNumber", SiteConfig::getSitePhoneNumber);
		attributeSetterBiConsumers.put(
			"sitePhoneNumber",
			(BiConsumer<SiteConfig, Long>)SiteConfig::setSitePhoneNumber);
		attributeGetterFunctions.put(
			"openinghours", SiteConfig::getOpeninghours);
		attributeSetterBiConsumers.put(
			"openinghours",
			(BiConsumer<SiteConfig, String>)SiteConfig::setOpeninghours);
		attributeGetterFunctions.put("copyright", SiteConfig::getCopyright);
		attributeSetterBiConsumers.put(
			"copyright",
			(BiConsumer<SiteConfig, String>)SiteConfig::setCopyright);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getSiteConfigId() {
		return _siteConfigId;
	}

	@Override
	public void setSiteConfigId(long siteConfigId) {
		_siteConfigId = siteConfigId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public Boolean getShowCustomUserRegistration() {
		return _showCustomUserRegistration;
	}

	@Override
	public void setShowCustomUserRegistration(
		Boolean showCustomUserRegistration) {

		_showCustomUserRegistration = showCustomUserRegistration;
	}

	@JSON
	@Override
	public String getSiteEmailAddress() {
		if (_siteEmailAddress == null) {
			return "";
		}
		else {
			return _siteEmailAddress;
		}
	}

	@Override
	public void setSiteEmailAddress(String siteEmailAddress) {
		_siteEmailAddress = siteEmailAddress;
	}

	@JSON
	@Override
	public long getSitePhoneNumber() {
		return _sitePhoneNumber;
	}

	@Override
	public void setSitePhoneNumber(long sitePhoneNumber) {
		_sitePhoneNumber = sitePhoneNumber;
	}

	@JSON
	@Override
	public String getOpeninghours() {
		if (_openinghours == null) {
			return "";
		}
		else {
			return _openinghours;
		}
	}

	@Override
	public void setOpeninghours(String openinghours) {
		_openinghours = openinghours;
	}

	@JSON
	@Override
	public String getCopyright() {
		if (_copyright == null) {
			return "";
		}
		else {
			return _copyright;
		}
	}

	@Override
	public void setCopyright(String copyright) {
		_copyright = copyright;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SiteConfig.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SiteConfig toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, SiteConfig>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SiteConfigImpl siteConfigImpl = new SiteConfigImpl();

		siteConfigImpl.setSiteConfigId(getSiteConfigId());
		siteConfigImpl.setGroupId(getGroupId());
		siteConfigImpl.setCompanyId(getCompanyId());
		siteConfigImpl.setUserId(getUserId());
		siteConfigImpl.setUserName(getUserName());
		siteConfigImpl.setCreateDate(getCreateDate());
		siteConfigImpl.setModifiedDate(getModifiedDate());
		siteConfigImpl.setShowCustomUserRegistration(
			getShowCustomUserRegistration());
		siteConfigImpl.setSiteEmailAddress(getSiteEmailAddress());
		siteConfigImpl.setSitePhoneNumber(getSitePhoneNumber());
		siteConfigImpl.setOpeninghours(getOpeninghours());
		siteConfigImpl.setCopyright(getCopyright());

		siteConfigImpl.resetOriginalValues();

		return siteConfigImpl;
	}

	@Override
	public int compareTo(SiteConfig siteConfig) {
		long primaryKey = siteConfig.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SiteConfig)) {
			return false;
		}

		SiteConfig siteConfig = (SiteConfig)object;

		long primaryKey = siteConfig.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		SiteConfigModelImpl siteConfigModelImpl = this;

		siteConfigModelImpl._originalGroupId = siteConfigModelImpl._groupId;

		siteConfigModelImpl._setOriginalGroupId = false;

		siteConfigModelImpl._setModifiedDate = false;

		siteConfigModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SiteConfig> toCacheModel() {
		SiteConfigCacheModel siteConfigCacheModel = new SiteConfigCacheModel();

		siteConfigCacheModel.siteConfigId = getSiteConfigId();

		siteConfigCacheModel.groupId = getGroupId();

		siteConfigCacheModel.companyId = getCompanyId();

		siteConfigCacheModel.userId = getUserId();

		siteConfigCacheModel.userName = getUserName();

		String userName = siteConfigCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			siteConfigCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			siteConfigCacheModel.createDate = createDate.getTime();
		}
		else {
			siteConfigCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			siteConfigCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			siteConfigCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Boolean showCustomUserRegistration = getShowCustomUserRegistration();

		if (showCustomUserRegistration != null) {
			siteConfigCacheModel.showCustomUserRegistration =
				showCustomUserRegistration;
		}

		siteConfigCacheModel.siteEmailAddress = getSiteEmailAddress();

		String siteEmailAddress = siteConfigCacheModel.siteEmailAddress;

		if ((siteEmailAddress != null) && (siteEmailAddress.length() == 0)) {
			siteConfigCacheModel.siteEmailAddress = null;
		}

		siteConfigCacheModel.sitePhoneNumber = getSitePhoneNumber();

		siteConfigCacheModel.openinghours = getOpeninghours();

		String openinghours = siteConfigCacheModel.openinghours;

		if ((openinghours != null) && (openinghours.length() == 0)) {
			siteConfigCacheModel.openinghours = null;
		}

		siteConfigCacheModel.copyright = getCopyright();

		String copyright = siteConfigCacheModel.copyright;

		if ((copyright != null) && (copyright.length() == 0)) {
			siteConfigCacheModel.copyright = null;
		}

		return siteConfigCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SiteConfig, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SiteConfig, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SiteConfig, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SiteConfig)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<SiteConfig, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SiteConfig, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SiteConfig, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SiteConfig)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, SiteConfig>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _siteConfigId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private Boolean _showCustomUserRegistration;
	private String _siteEmailAddress;
	private long _sitePhoneNumber;
	private String _openinghours;
	private String _copyright;
	private long _columnBitmask;
	private SiteConfig _escapedModel;

}