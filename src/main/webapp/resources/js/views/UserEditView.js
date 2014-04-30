

window.UserdEditView = Backbone.View.extend({
    template:_.template($('#user-edit').html()),
    
    initialize:function () {
    	console.log("UserdEditView->initialize");
        this.options.model2.bind("reset", this.render, this);
        this.options.model3.bind("reset", this.render, this);
        this.options.model4.bind("reset", this.render, this);
    },
    
    events: {
		"click .save": "saveUser",
		"click .back": "back",
    },
    
    render:function (eventName) {
    	console.log("UserdEditView->render...");
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
		
		
		
		var changedAttr = this.model.changedAttributes();
		if (changedAttr){
			console.log("Changed attributes: ");
			console.log(changedAttr);
			this.model.save(null,{
				success:function(model, response){
					console.log("model saved succeesfully");
					window.history.back();
				},
				error: function(model, response){
					alert("Ошибка сохранения данных на сервере");
				},
			});
		} else {
			alert ("Данные пользователя не были изменены");
		}
	 	
		return false;
	},

	back: function(){
		console.log("back to main");
		window.history.back();
	},
		
});
