window.PaginatedView = Backbone.View.extend({

    events: {
      'click a.servernext': 'nextResultPage',
      'click a.serverprevious': 'previousResultPage',
      'click a.page': 'gotoPage',
      'click a.serverpage': 'gotoPage',


    },

    tagName: 'aside',

    template: _.template($('#tmpServerPagination').html()),

    initialize: function () {
    	console.log("PaginatedView->initialize ");
      var mod = this.collection;
      mod.on('reset', this.render, this);
      mod.on('sync', this.sync, this);

      this.$el.appendTo('#pagination');

    },

    render: function () {
    	console.log("PaginatedView->render ");
      var html = this.template(this.collection.info());
      this.$el.html(html);
    },
    
    sync: function (){
    	console.log("PaginatedView->sync ");
    	this.render();
    	
    },

    nextResultPage: function (e) {
      this.collection.trigger("change");
      e.preventDefault();
      this.collection.requestNextPage();
    },

    previousResultPage: function (e) {
    	this.collection.trigger("change");
      e.preventDefault();
      this.collection.requestPreviousPage();
    },

    gotoPage: function (e) {
    	this.collection.trigger("change");
      e.preventDefault();
      var page = $(e.target).text();
      this.collection.goTo(page);
    },

  });


