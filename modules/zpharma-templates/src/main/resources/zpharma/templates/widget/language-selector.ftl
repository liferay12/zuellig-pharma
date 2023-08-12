<#if entries?has_content>
	<#assign languageId = localeUtil.toLanguageId(locale) />

	<style>
		.taglib-language-option {
			background: none no-repeat 5px center;
			padding-left: 25px;
		}
		.language-selector .form-group {
		    margin-bottom: 0px;
		}
		.language-selector .form-group .form-control{
		    font-size: inherit;
		        height: 1.5rem;
		        padding-bottom: 0px;
		        padding-top: 0px;
		}
		

		<#list entries as entry>
			.taglib-language-option-${entry.getW3cLanguageId()} {
				background-image: url(${themeDisplay.getPathThemeImages()}/language/${entry.getLanguageId()}.png);
			}
		</#list>
	</style>

	<@liferay_aui["form"]
		action=formAction
		method="post"
		name='${namespace + formName}'
		useNamespace=false
		cssClass="language-selector"
	>
		<@liferay_aui["select"]
			changesContext=true
			cssClass="font-selection"
			id='${namespace + formName}'
			label=""
			name='${name}'
			onChange='${namespace + "changeLanguage();"}'
			title="language"
		>
			<#list entries as entry>
				<@liferay_aui["option"]
					cssClass="taglib-language-option taglib-language-option-${entry.getW3cLanguageId()}"
					disabled=entry.isDisabled()
					label=entry.getLongDisplayName()
					lang=entry.getW3cLanguageId()
					localizeLabel=false
					id="language-option-${entry.getLocale()}"
					selected=entry.isSelected()
					value=entry.getLanguageId()
				/>
			</#list>
		</@>
	</@>

	<@liferay_aui["script"]>
		function ${namespace}changeLanguage() {
			submitForm(document.${namespace + formName});
		}
	</@>
</#if>
<script>
$(document).ready(function(){
    var hindiOption = document.getElementById("language-option-hi_IN");
    if(hindiOption){
        hindiOption.text = hindiOption.text.replace('[beta]','');
    }
    
    //$(".portlet-topper").hide();
    
});

</script>