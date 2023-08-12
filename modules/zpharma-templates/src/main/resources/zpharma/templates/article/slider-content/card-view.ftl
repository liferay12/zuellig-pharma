<style>
   @keyframes moveLeftActive {
	from {
		transform: translateX(0);
	}
	to {
		transform: translateX(100%);
	}
}

@keyframes moveLeft {
	from {
		transform: translateX(-100%);
	}
	to {
		transform: translateX(0);
	}
}

@keyframes moveRightActive {
	from {
		transform: translateX(0);
	}
	to {
		transform: translateX(-100%);
	}
}

@keyframes moveRight {
	from {
		transform: translateX(100%);
	}
	to {
		transform: translateX(0);
	}
}

.section-slider .carousel {
	position: relative;
}

.section-slider .carousel-caption {
	bottom: 50%;
	left: 0;
	right: 0;
	transform: translateY(50%);
}

.section-slider .carousel-item {
	opacity: 0;
}

.section-slider .carousel-item.move-right,
.section-slider .carousel-item.move-left {
	animation-duration: 0.6s;
	animation-iteration-count: 1;
	display: block;
}

.section-slider .carousel-item.active,
.section-slider .carousel-item.move-left,
.section-slider .carousel-item.move-right {
	opacity: 1;
}

.section-slider .carousel-item.active {
	transform: translateX(0);
}

.section-slider .carousel-item.active.move-left {
	animation-name: moveLeftActive;
}

.section-slider .carousel-item.move-left {
	animation-name: moveLeft;
}

.section-slider .carousel-item.active.move-right {
	animation-name: moveRightActive;
}

.section-slider .carousel-item.move-right {
	animation-name: moveRight;
}

.section-slider .carousel-navigation {
	bottom: 10px;
	display: flex;
	justify-content: center;
	left: 0;
	list-style: none;
	padding-left: 0;
	position: absolute;
	right: 0;
	z-index: 15;
}

.section-slider .carousel-navigation button {
	background-color: rgba(255, 255, 255, 0.5);
	border: 0;
	flex: 0 1 auto;
	height: 3px;
	margin-left: 3px;
	margin-right: 3px;
	position: relative;
	width: 30px;
}

.section-slider .carousel-navigation button:focus {
	outline: 0;
	text-decoration: none;
}

.section-slider .carousel-navigation button.active {
	background-color: rgba(255, 255, 255, 1);
}

.section-slider{padding-top:40px;}
.section-slider .carousel-item img{border:1px solid #f1f1f1;}
.section-slider .carousel {background: white; padding: 24px; box-shadow: 0px 0px 2px 2px #f1f1f1; border-radius: 20px;
}



</style>

<div class="section-slider">

<div class="carousel">
   <ol class="carousel-navigation">
      <#if title.getSiblings()?has_content>
      <#list title.getSiblings() as cur_title>
      <li>
         <#if cur_title?index==0>
             <button aria-controls="_carouselInner" class="active" type="button">
                <span class="sr-only">Focus first slide</span>
             </button>
         <#else>
             <button aria-controls="_carouselInner" type="button">
                <span class="sr-only">Focus next slide</span>
             </button>
         </#if>
      </li>
      </#list>
      </#if>
   </ol>
   <div class="carousel-inner text-break" id="_carouselInner" role="group">
      <#if title.getSiblings()?has_content>
      <#list title.getSiblings() as title>
      <#if title?index==0>
      <div class="carousel-item active">
         <#else>
         <div class="carousel-item">
            </#if>
            <#if (title.carouselImage.getData())?? && title.carouselImage.getData() != "">
            <img alt="${title.carouselImage.getAttribute("alt")}" class="w-100" data-fileentryid="${title.carouselImage.getAttribute("fileEntryId")}" src="${title.carouselImage.getData()}" style=" height:430px;" />
            </#if>
            <div class="carousel-caption d-none d-md-block">
               <div class="container">
                  <div class="row">
                     <div class="col-12 col-md-8 col-xl-6  text-left">
                        <#if title.getData()!="">
                        <h1 data-lfr-editable-id="01-02-title" data-lfr-editable-type="rich-text">
                           ${title.getData()}
                        </h1>
                        </#if>
                        <#if title.subTitle.getData()!="">
                        <div class="lead mb-4" data-lfr-editable-id="01-03-subtitle" data-lfr-editable-type="rich-text">
                           <p>
                              ${title.subTitle.getData()}
                           </p>
                        </div>
                        </#if>
                        <#if title.link.getData()!="">
                        <a class="btn btn-primary" data-lfr-editable-id="01-04-link" data-lfr-editable-type="link" href="${title.link.getData()}" id="fragment-1-01-04-link">
                        Visit Link
                        </a>
                        </#if>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         </#list>
         </#if>
      </div>
   </div>
</div>
<script>
   const MOVE_LEFT = 'move-left';
   const MOVE_RIGHT = 'move-right';
   const INTERVAL = 5000;
   
   const editMode = document.body.classList.contains('has-edit-mode-menu');
   const indicators = [].slice.call(
   	document.querySelectorAll('.carousel-navigation button')
   );
   const items = [].slice.call(document.querySelectorAll('.carousel-item'));
   
   let moving = false;
   
   function getActiveIndicator() {
   	return document.querySelector('.carousel-navigation .active');
   }
   
   function move(movement, index = null) {
   	if (moving) {
   		return;
   	}
   
   	moving = true;
   
   	const activeItem = document.querySelector('.carousel-item.active');
   	const indexActiveItem = items.indexOf(activeItem);
   	const activeIndicator = getActiveIndicator();
   
   	let nextItemIndex = index;
   	
   	
   	<#if title.getSiblings()?has_content>
		<#assign numberOfBanners = title.getSiblings()?size>
    </#if>
   	if (index === null) {
   		nextItemIndex = indexActiveItem >= ${numberOfBanners}-1 ? 0 : indexActiveItem + 1;
   	}
   
   	const nextItem = items[nextItemIndex];
   
   	activeItem.classList.add(movement);
   	nextItem.classList.add(movement);
   	activeIndicator.classList.remove('active');
   	indicators[nextItemIndex].classList.add('active');
   
   	setTimeout(function () {
   		activeItem.classList.remove('active', movement);
   		nextItem.classList.add('active');
   		nextItem.classList.remove(movement);
   
   		moving = false;
   	}, 600);
   }
   
   function createInterval() {
   	let intervalId = null;
   
   	if (!editMode) {
   		intervalId = setInterval(function () {
   			if (document.contains(items[0])) {
   				move(MOVE_RIGHT);
   			}
   			else {
   				clearInterval(intervalId);
   			}
   		}, INTERVAL);
   	}
   
   	return intervalId;
   }
   
   (function main() {
   	let intervalId = createInterval();
   
   	indicators.forEach(function (indicator, index) {
   		indicator.addEventListener('click', function () {
   			const indexActiveIndicator = indicators.indexOf(
   				getActiveIndicator()
   			);
   
   			if (index !== indexActiveIndicator) {
   				if (index < indexActiveIndicator) {
   					move(MOVE_LEFT, index);
   				}
   				else {
   					move(MOVE_RIGHT, index);
   				}
   			}
   
   			clearInterval(intervalId);
   			intervalId = createInterval();
   		});
   	});
   })();
</script>