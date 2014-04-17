$(document).ready(function() {
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
                            max: 60,
                            message:  'Это поле должно иметь длину от 2 до 60 символов и не содержать специальные символы или цифры!'   
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
                            max: 60,  
                            message:   'Это поле должно иметь длину от 2 до 60 символов и не содержать специальные символы или цифры!' ,
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
	            userLogin:{
	            	validators: {
	            		 notEmpty: {
	                         message: 'Укажите пожалуйста свой логин!'
	                     },
	                     stringLength: {
	                            min: 5,
	                            max: 60,  
	                            message: 'Это поле должно иметь длину от 5 до 60 символов !',
	                       },
	                       regexp: {
		                       regexp:  /^([\w]+[\._-]*)+$/,  
		                       message:'Это поле  содержать только символы латинского алфавита, цифры, символы "-" "_" "." !'
//		                  },
//		                  remote: {
//		                        url: '',
		                       // message: 'The username is not available'
		                    },
	                     
	            	 }
	            },
	            
	            email:{
	            	validators: {
	            		notEmpty: {
	                         message: 'Укажите пожалуйста свой E-mail адрес!'
	                     },
	                    regexp: {
		                     regexp: /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,10})+$/,
		                     message:'Это поле  содержать только символы латинского алфавита, цифры, символы "-" "_" "." !'		                 
		                 },
		                // remote: {
		                       //url: '',
		                       // message: 'The username is not available'
		                    //},
	            		
	            	}         	
	            },
	            password:{
	            	validators: {
	                    notEmpty: {
	                        message: 'Это поле обязательное для заполнения и не может быть пустым !' 
	                    },
	                    stringLength: {
                            min: 5,
                            max: 60,  
                            message: 'Это поле должно иметь длину от 5 до 60 символов и содержать только символы латинского алфавита  или цифры !',
                       },
                       regexp: {
	                       regexp: /^[\w\d-_\.]+$/,  
	                       message:'Это поле  содержать только символы латинского алфавита, цифры, символы "-" "_" "." !'
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
//	        highlight: function(element) {
//	            $(element).closest('.form-group').addClass('has-error');
//	        },
//	        unhighlight: function(element) {
//	            $(element).closest('.form-group').removeClass('has-error');
//	        },
	        
	    });
	            

	    
	    

	    // Validate the form manually
	  //  $('#validateBtn').click(function() {
	      //  $('#contact-form').bootstrapValidator('validate');
   // });

	    $('#resetBtn').click(function() {
	        $('#contact-form').data('bootstrapValidator').resetForm(true);
	    });
	});


//$(document).ready(function () {
//    
//    $('#datepicker').datepicker({
//        format: "dd/mm/yyyy", 
//    });  
    
//    $('#datepicker').validate({ 
//        errorPlacement: $.datepicker.errorPlacement, 
//        rules: { 
//            validDefaultDatepicker: { 
//                required: true, 
//                dpDate: true 
//            }, 
//            validBeforeDatepicker: { 
//                dpCompareDate: ['before', '#validAfterDatepicker'] 
//            }, 
//            validAfterDatepicker: { 
//                dpCompareDate: {after: '#validBeforeDatepicker'} 
//            }, 
//            validTodayDatepicker: { 
//                dpCompareDate: 'ne today' 
//            }, 
//            validSpecificDatepicker: { 
//                dpCompareDate: 'notBefore 01/01/2012' 
//            } 
//        }, 
//        messages: { 
//            validFormatDatepicker: 'Please enter a valid date (yyyy-mm-dd)', 
//            validRangeDatepicker: 'Please enter a valid date range', 
//            validMultiDatepicker: 'Please enter at most three valid dates', 
//            validAfterDatepicker: 'Please enter a date after the previous value' 
//        }});
//    
    

//});



