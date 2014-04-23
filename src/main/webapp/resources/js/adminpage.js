
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
 
window.UserdView = Backbone.View.extend({
    template:_.template($('#user-edit').html()),
    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
});

window.UserdDetailsView = Backbone.View.extend({
    template:_.template($('#user-details').html()),
    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
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
        "details/:id" : "userDetails",
        "remove/:id" : "userRemove",
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
        this.userdView = new UserdView({model:this.userd});
        $('#content').html(this.userdView.render().el);
    },
    
    userDetails:function (id) {
    	console.log("Backbone.Router->userDetails:...");
        this.userd = this.userdList.get(id);
        this.userdDetailsView = new UserdDetailsView({model:this.userd});
        $('#content').html(this.userdDetailsView.render().el);
    },
    
    userRemove:function (id) {
    	console.log("Backbone.Router->userRemove:...");
    	this.userd = this.userdList.get(id);
    	var userAttributes = this.userd.get("userStatus");
    	userAttributes.status = "Запись удалена";
    	this.userd.set({"userStatus": userAttributes});
    	console.log("this.userd.isNew "+this.userd.isNew());
    	console.log(this.userd);
    	this.userd.save({
			success: function(model,response) {
				console.log("Backbone.Router->userRemove->success");
			},
	    	error: function(){
	    		console.log("Backbone.Router->userRemove->error");
	    	}
    	});

   },
    
    main:function () {
    	console.log("Backbone.Router->main:...");
    	$('#content').html(this.userdListView.el);
    },
    
      
    
});



 
var app = new AppRouter();
Backbone.history.start();

});
