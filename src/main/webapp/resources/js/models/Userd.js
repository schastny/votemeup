window.Userd = Backbone.Model.extend({
	idAttribute: "userdId",

	validate: function(attrs) {
		console.log("window.Userd->validate");
		$('#errors').html("");
        var error = [];
        
        if(attrs.userLogin.length < 3 || attrs.userLogin.length > 20){
        	error.push({message:"  Логин должен иметь длину от 3 до 20 символов"});
        }
        
        var patt = new RegExp("^[0-9A-Za-z\._-]+$");
        if(!patt.test(attrs.userLogin)){
        	error.push({message:"  Логин должен содержать только символы латинского алфавита, цифры и символы '-', '_', '.'"});
        }        
        
        if(attrs.firstName.length < 2 || attrs.firstName.length > 50){
        	error.push({message:"  Имя должно иметь длину от 2 до 50 символов"});
        }
        
        patt = new RegExp("^([A-Za-zА-Яа-я]+[ -]*)+$");
        if(!patt.test(attrs.firstName)){
        	error.push({message:"  Имя не может содержать специальные символы,цифры или начинаться со знака тире(-)"});
        }        
        
        if(attrs.lastName.length < 2 || attrs.lastName.length > 50){
        	error.push({message:"  Фамилия должна иметь длину от 2 до 50 символов"});
        }
        
        patt = new RegExp("^([A-Za-zА-Яа-я]+[ -]*)+$");
        if(!patt.test(attrs.lastName)){
        	error.push({message:"  Фамилия не может содержать специальные символы,цифры или начинаться со знака тире(-)"});
        }   
        
        if(attrs.userPassword.length != 40){
        	error.push({message:"  Хэш пароля в кодировке SHA1 должен содержать 40 символов"});
        }
        
        patt = new RegExp("^[0-9a-fA-F]+$");
        if(!patt.test(attrs.userPassword)){
        	error.push({message:"  Хэш пароля в кодировке SHA1 должен состоять из шестнадцатиричных символов"});
        } 
        
        if(attrs.email.length > 255){
        	error.push({message:"  Длина Email ограничена 255 символами"});
        }
        
        patt =  new RegExp("^[_A-Za-z0-9-\+]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$");
        if(!patt.test(attrs.email)){
        	error.push({message:"  Введен неверный Email"});
        } 
        
        var age = new Date().getFullYear() - attrs.birthYear;
        if(age < 14 || age > 120){
        	error.push({message:" Год рождения указан неверно. Возраст не должен быть меньше 14 и больше 120 лет"});
        }
        
        if (error.length > 0){
        	this.trigger("error",this, error);
        	return true;
        } else
        	return false;;
    },

});
