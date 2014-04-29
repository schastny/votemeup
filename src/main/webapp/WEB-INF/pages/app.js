
var AppRouter = Backbone.Router.extend({
 
    routes:{
        "":"list",
    },
    
    initialize:function(){ 
		console.log("Backbone.Router->initialize");
 	},
  
    list:function () {
    	console.log("Backbone.Router->list");
        this.paginatedItems = new PaginatedCollection();
        console.log(this.paginatedItems);
		this.appView = new AppView({collection: this.paginatedItems});
		this.paginatedView = new PaginatedView({collection:this.paginatedItems})
    	},

});


$(function(){
var app = new AppRouter();
Backbone.history.start();
});