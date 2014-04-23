
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
    
    events: {
		"click .save": "saveUser",
    },
    
    
    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },
    
	saveUser: function() {
		console.log("UserdEditView->saveUser...");
		console.log(this.model);
		
		this.model.set({
			userLogin: $('#userLogin').val(),
			email: $('#email').val(),
			userPassword: $('#userPassword').val(),
			firstName: $('#firstName').val(),
			lastName: $('#lastName').val(),
			birthYear: $('#birthYear').val(),
			country: $('#country').val(),
			sex: $('#sex').val(),
			role: $('#role').val(),
			userStatus: $('#userStatus').val()
		});
		this.model.save();
		return false;
	}
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
        "users/:id":"userEdit",
        "main":"main"
    },
    
    initialize:function(){
   	 this.admin = new Admin();
    	this.currentAdminView = new CurrentAdminView({model:this.admin});
    	this.admin.fetch({success: function(m, resp) { 
    		//console.log(resp);
    		},
        });
        $('#content2').html(this.currentAdminView.el);
   	
   },

 
    list:function () {
    	console.log("Backbone.Router->list:...");
        this.userdList = new UserdCollection();
        this.userdListView = new UserdListView({model:this.userdList});
        this.userdList.fetch();
        $('#content').html(this.userdListView.render().el);
    },
 
    userEdit:function (id) {
    	console.log("Backbone.Router->userEdit:...");
        this.userd = this.userdList.get(id);
        this.userdEditView = new UserdEditView({model:this.userd});
        $('#content').html(this.userdEditView.render().el);
    },
    
    main:function () {
    	console.log("Backbone.Router->main:...");
    	$('#content').html(this.userdListView.el);
    },
    
      
    
});



 
var app = new AppRouter();
Backbone.history.start();

});
