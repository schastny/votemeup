window.UserdListView = Backbone.View.extend({

	template:_.template($('#user-table').html()),
 
    initialize:function () {
    	console.log("UserdListView->initialize");
        var tags = this.collection;
        tags.on('add', this.addOne, this);
        tags.on('change', this.render, this);
        tags.pager();


   },

   render:function (eventName) {
    	console.log("UserdListView->render");
    	$(this.el).html(this.template(this.collection.toJSON()));
    },
    
    addOne : function ( item ){
    	console.log("UserdListView->addOne");
        $('tbody').append(new UserdListItemView({model:item}).render().el);
    },
  
});