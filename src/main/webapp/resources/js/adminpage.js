

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
    	console.log("Backbone.Router->list");
        this.userdList = new PaginatedCollection();
        this.userdList.currentPage = this.curPage;
 		this.userdListView = new UserdListView({collection:this.userdList});
 		this.paginatedView = new PaginatedView({collection:this.userdList});
 		$('#content').html(this.userdListView.el);
     
    },
 
    userEdit:function (id) {
    	console.log("Backbone.Router->userEdit, id="+id);
		this.countryList = new CountryCollection();
        this.roleList = new RoleCollection();
        this.userStatusList = new UserStatusCollection();
        this.countryList.fetch({
        	success:function(model){model.trigger("reset");}
        });
        this.roleList.fetch({
        	success:function(model){model.trigger("reset");}
        });
        this.userStatusList.fetch({
        	success:function(model){model.trigger("reset");}
        });
        this.userd = this.userdList.get(id);
        console.log("currentPage"+this.userdList.currentPage);
        this.curPage = this.userdList.currentPage;
        this.userdEditView = new UserdEditView({model:this.userd, model2:this.countryList,
            model3:this.roleList, model4:this.userStatusList});
        $('#content').html(this.userdEditView.el);
        $('#pagination').html("");
 
        
    },

});

$(function(){
console.log("Entry point.");
var app = new AppRouter();
Backbone.history.start();

});
