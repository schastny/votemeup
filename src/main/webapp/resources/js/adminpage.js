
$(function(){

// Models
window.Userd = Backbone.Model.extend({
	 idAttribute: "userdId",
});
window.UserdCollection = Backbone.Collection.extend({
    model:Userd,
    url:"../api/users"
});

window.Admin = Backbone.Model.extend({
	url:"../api/users/current"
});

window.Country = Backbone.Model.extend({
	 idAttribute: "countryId",
});
window.CountryCollection = Backbone.Collection.extend({
   model:Country,
   url:"../api/countries"
});

window.Role = Backbone.Model.extend({
	 idAttribute: "roleId",
});
window.RoleCollection = Backbone.Collection.extend({
    model:Role,
    url:"../api/roles"
});

window.UserStatus = Backbone.Model.extend({
	 idAttribute: "id",
});
window.UserStatusCollection = Backbone.Collection.extend({
   model:UserStatus,
   url:"../api/userStatuses"
});


 
// Views
window.UserdListView = Backbone.View.extend({

	template:_.template($('#user-table').html()),
 
    initialize:function () {
    	console.log("UserdListView->initialize...");
        this.model.bind("reset", this.render, this);
        this.model.bind("change", this.render, this);
        this.model.bind("destroy", this.render, this);
   },
   render:function (eventName) {
    	console.log("UserdListView->render...");
        $(this.el).html(this.template());
        _.each(this.model.models, function (userd) {
             $('tbody').append(new UserdListItemView({model:userd}).render().el);
        }, this);
        return this;
    },

});
 
window.UserdListItemView = Backbone.View.extend({
	tagName : "tr",
    template:_.template($('#user-list-item').html()),
 
    render:function (eventName) {
    	console.log("UserdListItemView->render...");
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
 
});

window.UserdEditView = Backbone.View.extend({
    template:_.template($('#user-edit').html()),
    
    initialize:function () {
    	console.log("UserdEditView->initialize...");
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
            isSelected: this.model.get("status"),
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


window.CurrentAdminView = Backbone.View.extend({
	template:_.template($('#current-admin').html()),
	initialize:function () {
    	console.log("CurrentAdminView->initialize...");
        this.model.bind("change", this.render, this);
    },
    
    render:function (eventName) {
    	console.log("CurrentAdminView->render:...");
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
});

 
// Router
var AppRouter = Backbone.Router.extend({
 
    routes:{
        "":"list",
        "main":"main",
        "users/:id":"userEdit",
    },
    
    initialize:function(){
   	 this.admin = new Admin();
    	this.currentAdminView = new CurrentAdminView({model:this.admin});
    	this.admin.fetch();
        $('#content2').html(this.currentAdminView.el);
   	
   },
   
   /*
   this.wineList = new WineCollection();
   var self = this;
   this.wineList.fetch({
       success:function () {
           self.wineListView = new WineListView({model:self.wineList});
           $('#sidebar').html(self.wineListView.render().el);
           if (self.requestedId) self.wineDetails(self.requestedId);
       }
   });
*/
 
    list:function () {
    	console.log("Backbone.Router->list:...");
    	if (!this.userdList){
    		console.log("Backbone.Router->list:!this.userdList");
	        this.userdList = new UserdCollection();
	        
    	}
        this.userdList.fetch();
    	if (!this.userdListView){
    		console.log("Backbone.Router->list:!this.userdListView");
    		this.userdListView = new UserdListView({model:this.userdList});
    	}
        $('#content').html(this.userdListView.el);
    },
 
    userEdit:function (id) {
    	console.log("Backbone.Router->userEdit:...");
		this.countryList = new CountryCollection();
        this.roleList = new RoleCollection();
        this.userStatusList = new UserStatusCollection();
        this.countryList.fetch();
        this.roleList.fetch();
        this.userStatusList.fetch();

        this.userd = this.userdList.get(id);
        this.userdEditView = new UserdEditView({model:this.userd, model2:this.countryList,
            model3:this.roleList, model4:this.userStatusList});
        
        
        $('#content').html(this.userdEditView.el);
        
    },
    /*
    main: function(){
    	console.log("Backbone.Router->main:...");
    	if (!this.userdList){
    		console.log("Backbone.Router->list:!this.userdList");
	        this.userdList = new UserdCollection();
    	}
    	this.userdList.fetch();
        $('#content').html(this.userdListView.el);
    }
    */
});



 
var app = new AppRouter();
Backbone.history.start();

});
