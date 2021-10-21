  $(document).ready(function() {
    $('#autoWidth').lightSlider({
        autoWidth:true,
        loop:true,
        onSliderLoad: function() {
            $('#autoWidth').removeClass('cS-hidden');
        } 
   
    	
    });  
  });
  
  $(document).ready(function() {
	    $('#autoWidth2').lightSlider({
	        autoWidth:true,
	        loop:true,
	        onSliderLoad: function() {
	            $('#autoWidth2').removeClass('cS-hidden');
	        } 
	   
	    	
	    });  
	  });
	  
  $(document).ready(function() {
	    $('#autoWidth3').lightSlider({
	        autoWidth:true,
	        loop:true,
	        onSliderLoad: function() {
	            $('#autoWidth3').removeClass('cS-hidden');
	        } 
	   
	    	
	    });  
	  });
	  
	  	  
  $(document).ready(function() {
	    var slider = $("#lightSlider").lightSlider();
	    slider.goToSlide(3);
	    slider.goToPrevSlide();
	    slider.goToNextSlide();
	    slider.getCurrentSlideCount();
	    slider.refresh();
	    slider.play(); 
	    slider.pause();    
	  });