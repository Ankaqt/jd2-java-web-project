window.addEventListener("scroll", function() {
	checkScroll();
});

document.addEventListener("DOMContentLoaded", function() {
	checkScroll();
});

function checkScroll() {
	let wrap = $('.wrap');
	let wrapHeight = wrap.height();

	if ($(this).scrollTop() > 0) {
		wrap.addClass('wrap_fixed');
		$('body').css({
			'paddingTop': wrapHeight + 'px'
		});
		
	} else {
		wrap.removeClass('wrap_fixed');
		$('body').css({
			'paddingTop': 0
		})
	}
}
