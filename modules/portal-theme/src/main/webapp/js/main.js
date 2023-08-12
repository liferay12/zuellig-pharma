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

/*
 * This function gets loaded when all the HTML, not including the portlets, is
 * loaded.
 */
AUI().ready(function () {});

/*
 * This function gets loaded after each and every portlet on the page.
 *
 * portletId: the current portlet's id
 * node: the Alloy Node object of the current portlet
 */
Liferay.Portlet.ready(function (_portletId, _node) {});

/*
 * This function gets loaded when everything, including the portlets, is on
 * the page.
 */
Liferay.on('allPortletsReady', function () {});


function currentTime() {
	  let date = new Date(); 
	  let hh = date.getHours();
	  let mm = date.getMinutes();
	  let ss = date.getSeconds();
	  let session = "AM";

	  if(hh == 0){
	      hh = 12;
	  }
	  if(hh > 12){
	      hh = hh - 12;
	      session = "PM";
	   }

	   hh = (hh < 10) ? "0" + hh : hh;
	   mm = (mm < 10) ? "0" + mm : mm;
	   ss = (ss < 10) ? "0" + ss : ss;
	    
	   let time = hh + ":" + mm + ":" + ss + " " + session;

	  document.getElementById("currentClock").innerText = time; 
	  let t = setTimeout(function(){ currentTime() }, 1000);
	}
	currentTime();
	
//Date
	function currentDate() {
	const monthNames = ["January", "February", "March", "April", "May", "June",
		  "July", "August", "September", "October", "November", "December"
		];

	var today = new Date();
	var dd = String(today.getDate()).padStart(2, '0');
	var mm = monthNames[today.getMonth()]; //January is 0!
	var yyyy = today.getFullYear();

	today = dd +" "+ mm +", "+yyyy;
	
	document.getElementById("currentDate").innerText = today;
	
}
	
	currentDate();
