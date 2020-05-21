$(document).ready(function() {
					
					$(".toWishList").click(function() {
						console.log('redirect called');
						window.location.href = "index.html?name=WishList";
						$(window).scrollTop(0);
					});
					
					$(".dropdown").hover(            
							function() {
							  $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,false).slideDown("400");
							  $(this).toggleClass('open');        
							},
							function() {
							  $('.dropdown-menu', this).not('.in .dropdown-menu').stop(true,false).slideUp("400");
							  $(this).toggleClass('open');       
							});
					

				});


