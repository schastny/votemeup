
$(function(){

// Models
window.Userd = Backbone.Model.extend({
	 idAttribute: "userdId"
});
 
window.UserdCollection = Backbone.Collection.extend({
    model:Userd,
    url:"../api/users"
});
 
// Views
window.UserdListView = Backbone.View.extend({
 
    /*tagName:'ul',*/
	template:_.template($('#user-table').html()),
 
    initialize:function () {
    	console.log("UserdListView->initialize...");
        this.model.bind("reset", this.render, this);
    },
 
    render:function (eventName) {
        _.each(this.model.models, function (userd) {
            $(this.el).append(new UserdListItemView({model:userd}).render().el);
        }, this);
        return this;
    }
 
});
 
window.UserdListItemView = Backbone.View.extend({
 
    tagName:"li",
 
    template:_.template($('#user-list-item').html()),
 
    render:function (eventName) {
    	console.log("UserdListItemView->render...");
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
 
});
 
window.UserdView = Backbone.View.extend({
 
    template:_.template($('#user-details').html()),
 
    render:function (eventName) {
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
 
});
 
// Router
var AppRouter = Backbone.Router.extend({
 
    routes:{
        "":"list",
        "users/:id":"userDetails"
    },
 
    list:function () {
    	console.log("Backbone.Router->list:...");
        this.userdList = new UserdCollection();
        this.userdListView = new UserdListView({model:this.userdList});
        this.userdList.fetch();
        $('#sidebar').html(this.userdListView.render().el);
    },
 
    userDetails:function (id) {
        this.userd = this.userdList.get(id);
        this.userdView = new UserdView({model:this.userd});
        $('#content').html(this.userdView.render().el);
    }
});
 
var app = new AppRouter();
Backbone.history.start();

});
