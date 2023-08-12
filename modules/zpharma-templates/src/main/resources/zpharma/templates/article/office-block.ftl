<section class="office_block">
<div class="container bgImageCtrl">
<div class="row">
<div class="col-md-8">
<#if (thumbnail.getData())?? && thumbnail.getData() != "">
	<img class="img-fluid" alt="${thumbnail.getAttribute("alt")}" data-fileentryid="${thumbnail.getAttribute("fileEntryId")}" src="${thumbnail.getData()}" />
</#if>
</div>
<div class="col-md-4"><ul class="list-unstyled"><li>Offices in 
<b>13 Countries</b></li>
<li>Employees 
<b>10,000</b></li>
<li>Serving Over
<b>290,000</b><p>Doctors, hospitals,
pharmacies & Clinics</p></li>
</ul></div>
</div>
</div><style>
.bgImageCtrl{position:relative: z-index:1;}
</style>
</section>