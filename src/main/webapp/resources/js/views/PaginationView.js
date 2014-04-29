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

      this.collection.on('reset', this.render, this);
      this.collection.on('sync', this.render, this);

      this.$el.appendTo('#pagination');

    },

    render: function () {
      var html = this.template(this.collection.info());
      this.$el.html(html);
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
    
    backToPage: function (page) {
        console.log("backToPage:"+page);
        this.collection.goTo(page);
      },

  });

