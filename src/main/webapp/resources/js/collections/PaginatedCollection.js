window.PaginatedCollection = Backbone.Paginator.requestPager.extend({

		model: Userd,

		paginator_core: {

			type: 'GET',
			dataType: 'json',
			url: '../api/users'
		},
		
		paginator_ui: {

			firstPage: 1,
			currentPage: 1,
			perPage: 7,
			totalPages: 10
		},
		
		server_api: {
			'per_page': function() { return this.perPage; },
			'page': function() { return this.currentPage; },
		},

		parse: function (response) {
			console.log("totalRecords: "+response.totalRecords);
			this.trigger("change");
			this.totalRecords = parseInt(response.totalRecords);
			this.totalPages = Math.ceil(response.totalRecords / this.perPage);

			//this.totalRecords = this.totalPages * this.perPage;
			return response.users;
		}

	});

