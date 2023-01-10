/**
 * 
 */
$(document).ready(function() {
	
	$.validator.setDefaults({
		errorClass: "invalid-feedback",
		highlight: function(element){
			$(element)
				.closest('.form-control')
				.addClass('is-invalid')
		},
		unhighlight: function(element){
			$(element)
				.closest('.form-control')
				.removeClass('is-invalid')
		}
	})
	
	$.validator.addMethod("customEmail", function (value, element) {
    return this.optional(element) || /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(value);
	}, "Please enter valid email address!");
	
	$("#regForm").validate({
		
		rules: {
			email: {
	          required: true,
	          customEmail: true
	        },
	        firstName: {
	          required: true,
	          normalizer: function(value) {
					  return $.trim(value);
				    }
	        },
	        lastName: {
	          required: true,
	          normalizer: function(value) {
					  return $.trim(value);
				    }
	        },
	        
	        pass: {
	          required: true,
	          minlength: 6,
	          maxlength: 25,
	          normalizer: function(value) {
					  return $.trim(value);
				    }
	        },
	       
	      },
	      messages: {
			email: {
	          required: 'Email is required'
	        },
	        firstName: {
	          required: 'First name is empty'
	        },
	        lastName: {
	          required: 'Last name is empty'
	        },
	        
	        pass: {
	          required: 'Password is required'
	        }

	      }
	})
})
