window.UserdListView = Backbone.View.extend({

	template:_.template($('#user-table').html()),
 
    initialize:function () {
    	console.log("UserdListView->initialize");
    //	$(this.el).html(this.template(this.collection.toJSON()));

        var tags = this.collection;
        tags.on('add', this.addOne, this);
        tags.on('change', this.change, this);
      //  tags.on('all', this.render, this);
        tags.pager();


   },
   change: function (){
	   console.log("UserdListView->change");
	   $(this.el).html(this.template(this.collection.toJSON()));
   },
   render:function (eventName) {
    	console.log("UserdListView->render");
    },
    
    addOne : function ( item ){
    	console.log("UserdListView->addOne");
    	//console.log(item);
         $('tbody').append(new UserdListItemView({model:item}).render().el);
    	 
    },
  
});