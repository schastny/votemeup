window.AppView = Backbone.View.extend({
    el : '#content',

    initialize : function () {
      console.log("AppView->initialize, tags:");
      var tags = this.collection;
      console.log(tags);
      tags.on('add', this.addOne, this);
      tags.on('all', this.render, this);
      tags.on('change', this.change, this);
      tags.pager();

    },

    addOne : function ( item ) {
      console.log("AppView->addOne");
      var view = new ResultView({model:item});
      $('#content').append(view.render().el);
    },

    render: function(){
    	console.log("AppView->render");
    },
    
    change: function(){
    	console.log("AppView->change");
    }
    
  });


