

window.UserdEditView = Backbone.View.extend({
    template:_.template($('#user-edit').html()),
    
    initialize:function () {
    	console.log("UserdEditView->initialize");
        this.options.model2.bind("reset", this.render, this);
        this.options.model3.bind("reset", this.render, this);
        this.options.model4.bind("reset", this.render, this);
        this.model.bind("error", this.validError, this);
    },
    
    events: {
		"click .save": "saveUser",
		"click .back": "back",
    },
    
    validError: function(obj ,error){
    	console.log("UserdEditView->error");
    	console.log(error);
  		 _.each(error, function (err) {
  			if (err.message)
  			$('#errors').append("<p><span class='glyphicon glyphicon-remove'></span>"+err.message+"</p>");
   		 }, this);


    },
    
    render:function (eventName) {
    	console.log("UserdEditView->render");
        $(this.el).html(this.template(this.model.toJSON()));
        
        //render selectboxes.
        var countrySelect = _.template($("#country-select").html(), {
            countries: this.options.model2,
            isSelected: this.model.get("country"),
        });
        $('#country-container').html(countrySelect);
               
        var sexSelect = _.template($("#sex-select").html(), {
            isSelected: this.model.get("sex"),
        });
        $('#sex-container').html(sexSelect);
        
        var roleSelect = _.template($("#role-select").html(), {
            roles: this.options.model3,
            isSelected: this.model.get("role"),
        });
        $('#role-container').html(roleSelect);
        
        var userStatusSelect = _.template($("#userStatus-select").html(), {
        	userStatuses: this.options.model4,
            isSelected: this.model.get("userStatus"),
        });
        $('#userStatus-container').html(userStatusSelect);
        
       
        return this;
    },
    
	saveUser: function() {
		console.log("UserdEditView->saveUser...");

	
		this.model.set({
			userLogin: $('#userLogin').val(),
			email: $('#email').val(),
			userPassword: $('#userPassword').val(),
			firstName: $('#firstName').val(),
			lastName: $('#lastName').val(),
			birthYear: parseInt($('#birthYear').val()),
			country: $('#country-selector').val(),
			sex: $('#sex-selector').val(),
			role: $('#role-selector').val(),
			userStatus: $('#userStatus-selector').val(), 
		},{silent:true});
		
		var valid = this.model.isValid();
		console.log(valid);
		if (!valid) return false;
		
		
		var changedAttr = this.model.changedAttributes();
		if (changedAttr){
			console.log("Changed attributes: ");
			console.log(changedAttr);
			this.model.save(null,{
				success:function(model, response){
					console.log("model saved succeesfully");
					window.history.back();
				},
				error: function(){
					$('#errors').append("<p><span class='glyphicon glyphicon-remove'></span>  Ошибка сохранения данных на сервере</p>");
				}
			});
		} else {
			$('#errors').append("<p><span class='glyphicon glyphicon-remove'></span>  Данные пользователя не были изменены</p>");
		}
	 	
		return false;
	},

	back: function(){
		console.log("back to main");
		$('#errors').html("");
		window.history.back();
	},
		
});
