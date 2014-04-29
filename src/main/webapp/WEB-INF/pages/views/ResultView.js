window.ResultView = Backbone.View.extend({
    tagName : 'li',
    template: _.template($('#resultItemTemplate').html()),

    initialize: function() {
    	console.log("ResultView->initialize");
      this.model.bind('change', this.render, this);
      this.model.bind('remove', this.remove, this);
    },

    render : function () {
    	console.log("ResultView->render ");
      this.$el.html(this.template(this.model.toJSON()));
      return this;
    }
  });


