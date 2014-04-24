
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

window.Role = Backbone.Model.extend({
	 idAttribute: "roleId",
});

window.RoleCollection = Backbone.Collection.extend({
    model:Role,
    url:"../api/roles"
});
 
// Views
window.UserdListView = Backbone.View.extend({

	template:_.template($('#user-table').html()),
 
    initialize:function () {
    	console.log("UserdListView->initialize...");
        this.model.bind("reset", this.render, this);
        this.model.bind("change", this.change, this);
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
    
    change: function(){
    	console.log("UserdListView->change...");
    	$('#content').html(this.el);
    	this.render();
   
    }
    

 
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
    
    events: {
		"click .save": "saveUser",
    },
    
    
    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
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
			country: $('#country').val(),
			sex: $('#sex').val(),
			role: $('#rol').val(),
			userStatus: $('#userStatus').val(), 
		},{ silent: true});
		 
		var changedAttr = this.model.changedAttributes();
		if (changedAttr){
			console.log(changedAttr);
			this.model.save();
			this.model.trigger("change");
			app.navigate("main");
		} else {
			alert ("Данные пользователя не были изменены");
		}
			
		
	 	
		return false;
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

 
    list:function () {
    	console.log("Backbone.Router->list:...");
    	if (!this.userdList){
    		console.log("Backbone.Router->list:!this.userdList");
	        this.userdList = new UserdCollection();
	        this.userdList.fetch();
    	}
	    this.userdListView = new UserdListView({model:this.userdList});
        $('#content').html(this.userdListView.el);
    },
 
    userEdit:function (id) {
    	console.log("Backbone.Router->userEdit:...");
        this.userd = this.userdList.get(id);
        this.userdEditView = new UserdEditView({model:this.userd});
        $('#content').html(this.userdEditView.render().el);
    },
    
    main: function(){
    	console.log("Backbone.Router->main:...");
        $('#content').html(this.userdListView.el);
    }
    
});



 
var app = new AppRouter();
Backbone.history.start();

});
