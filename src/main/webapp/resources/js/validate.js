$(document).ready(function() {
	$("#loginError").hide();
	$("#emailError").hide();
	$("#span").hide();
	$("#span2").hide();

	    $('#contact-form').bootstrapValidator({
	    	feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        //Фамилия
	        fields: {
	            firstName: {
	                validators: {
	                	 notEmpty: {
		                   	message:  'Это поле обязательное для заполнения и не может быть пустым !'                      		                                          		                      	
		                    },
	                     stringLength: {                    	
	                        min: 2,
	                        max: 50,
                            message:  'Это поле должно иметь длину от 2 до 50 символов и не содержать специальные символы или цифры!'   
                           },
                        regexp: {
	                       regexp: /^([A-Za-zА-Яа-я]+[ -]*)+$/,
	                       message:  'Это поле не может содержать специальные символы,цифры или начинаться со знака тире(-) !'                          
	                    }
	                }
	            },
	            //Имя
	            lastName: {
	                validators: {
	                    notEmpty: {
	                        message: 'Это поле обязательное для заполнения и не может быть пустым !',
	                    },
	                    stringLength: {
	                        min: 2,
	                        max: 50,
                            message:   'Это поле должно иметь длину от 2 до 50 символов и не содержать специальные символы или цифры!' ,
                       },
                       regexp: {
	                       regexp: /^([A-Za-zА-Яа-я]+[ -]*)+$/,  
	                       message:  'Это поле не может содержать специальные символы,цифры или начинаться со знака тире(-) !'    
	                  }
	                }
	            },
	            birthdate:{
	            	 validators: {
	            		 notEmpty: {
	                         message: 'Укажите пожалуйста год своего рождения!'
	                     },	
	            	 }
	            },
	            gender: {
	                validators: {
	                    notEmpty: {
	                        message: 'Укажите пожалуйста свой пол!'
	                    }
	                }
	            },
	            country:{
	            	 validators: {
	            		 notEmpty: {
	                         message: 'Укажите страну, в которой Вы проживаете!'
	                     }
	            	 }
	            },
	            password:{
	            	validators: {
	                    notEmpty: {
	                        message: 'Это поле обязательное для заполнения и не может быть пустым !' 
	                    },
	                    stringLength: {
	                    	min: 5,
	                    	max: 255,
                            message: 'Это поле обязательно для заполнения и должно сожержать от 5 до 255 символов!',
                       },
                       regexp: {
	                       regexp: /^[A-Za-zА-Яа-я\d-_\.]+$/,  
	                       message:'Это поле  содержать только символы латинского или русского алфавита, цифры, символы "-" "_" "." !'
	                  },
	                  	                    
	            	}            	
	            },
	            confirmPassword:{
	            	validators: {
	                    notEmpty: {
	                        message: 'Это поле обязательное для заполнения и не может быть пустым !' 
	                    },
	                    identical: {
	                        field: 'password',
	                        message: 'Введенные пароли не совпадают!'
	                    },                   	                    
	            	}            	
	            }	        
	        },
	    });
       	        
	    
	    $("#userLogin").change(function() {
	    	$("#userLogin").focusin(function(){
	    		$("#span").hide();
	    		$("#loginError").text("");
	    	});
	    		    
	    	var usLogin = $("#userLogin").val();
	    	var pattern =  /^((\w)+[\._-]*(\w)+)+$/;
	    		     	
	    	if((usLogin.length <= 2)|| (usLogin.length >=21)){
	    		loginError();
	    		$("#loginError").text("");
	    		$("#loginError").text("Это поле обязательно для заполнения и должно сожержать от 3 до 20 символов!");
	    	}
	    	else{
	    		if(!pattern.test(usLogin)){
	    			loginError();
	    			$("#loginError").text("");
		    		$("#loginError").text("Это поле  должно сожержать только символы латинского алфавита, цифры и символы '-', '_', '.' !");
	    		}
	    		else{
	    			$.ajax({
	  	    		  type: "POST",
	  	    		  url: "checkLogin",
	  	    		  data: {
	  	    			  userLogin: usLogin
	  	    		  }
	  	    		}).done(function(value) {
	  	    			
	  	    			if(value == "fail") {
	  	    				loginError();
	  	    				$("#loginError").text("");
	  	    				$("#loginError").text("Пользователь с таким логином уже зарегистрирован в системе!");
	  	    			}
	  	    			
	  	    			else{	 
	  	    				loginSuccess();
	  	    			};
	  	    		});
	    			
	    		}	       		
	    	}
	    	
	    });
	    
	    $("#userEmail").change(function() {
	    	$("#userEmail").focusin(function(){
	    		$("#span").hide();
	    		$("#emailError").text("");
	    	});
	    	
	    	var usEmail = $("#userEmail").val();
	    	var pattern =  /^\w+([\.\-_]*\w+)*@\w+([\.-]?\w+)*(\.\w{2,10})+$/;
	    	
	    	if(usEmail.length <= 4){
	    		emailError();
	    		$("#emailError").text("");
  				$("#emailError").text("Укажите пожалуйства свой e-mail адрес!");
	    	}
	    	else{
	    		if(!pattern.test(usEmail)){
	    			emailError();
	    			$("#emailError").text("");
	  				$("#emailError").text("Укажите корректный e-mail адрес!");	    			
	    		} 
	    		else{
	    			$.ajax({
		  	    		  type: "POST",
		  	    		  url: "checkEmail",
		  	    		  data: {
		  	    			  userEmail: usEmail
		  	    		  }
		  	    		}).done(function(value) {
		  	    			
		  	    			if(value == "fail") {
		  	    			  	emailError();
		  	    			    $("#emailError").text("");
		  	  				    $("#emailError").text("Пользователь с таким e-mail адресом уже зарегистрирован в системе!");
		  	    			}
		  	    			
		  	    			else{	 
		  	    				emailSuccess();
		  	    			};
		  	    	});	    			
	    		}
	    	}
	    	
	    });
	    	    	    	   	    	    
	    
	    function loginError(){
	    	$("#userLogin").closest(".form-group").removeClass("has-success").addClass("has-error");
			$("#span").removeClass("glyphicon glyphicon-ok form-control-feedback").addClass("glyphicon glyphicon-remove form-control-feedback").show();
			$("#loginError").show();
	    }
	    
	    function loginSuccess(){ 	
	    	$("#userLogin").closest('.form-group').removeClass("has-error").addClass("has-success");	    		
		    $("#span").removeClass("glyphicon glyphicon-remove form-control-feedback").addClass("glyphicon glyphicon-ok form-control-feedback").show();	    			
		    $("#loginError").hide();		
	    }
	    
	    function emailError(){
	    	$("#userEmail").closest(".form-group").removeClass("has-success").addClass("has-error");
			$("#span2").removeClass("glyphicon glyphicon-ok form-control-feedback").addClass("glyphicon glyphicon-remove form-control-feedback").show();		
			$("#emailError").show();
	    }
	    
	    function emailSuccess(){ 	
	    	$("#userEmail").closest('.form-group').removeClass("has-error").addClass("has-success");	    		
		    $("#span2").removeClass("glyphicon glyphicon-remove form-control-feedback").addClass("glyphicon glyphicon-ok form-control-feedback").show();	    			
		    $("#emailError").hide();		
	    }
	    
	    $("#resetBtn").click(function() {
	        $("#contact-form").data("bootstrapValidator").resetForm(true);
	        $("#loginError").hide();
	        $("#emailError").hide();
	        $("#span").hide();
	        $("#span2").hide();
	    });
	    
	    $("#validateBtn").click(function() {
	    	
	    	var usLogin = $("#userLogin").val();
	      	var usEmail = $("#userEmail").val();
	      	
	    	if(usLogin.length == 0){
	    		loginError();
	    		$("#loginError").text("");
	    		$("#loginError").text("Это поле обязательно для заполнения и не может быть пустым!");
	    		
	    	}
	    	if(usEmail.length == 0){
	    		emailError();
	    		$("#emailError").text("");
	    		$("#emailError").text("Это поле обязательно для заполнения и не может быть пустым!");
	    	}
	    	
	    });
	        
	  });

