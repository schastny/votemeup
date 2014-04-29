
window.CurrentAdminView = Backbone.View.extend({
	template:_.template($('#current-admin').html()),
	initialize:function () {
    	console.log("CurrentAdminView->initialize...");
        this.model.bind("change", this.render, this);
    },
    
    render:function (eventName) {
    	console.log("CurrentAdminView->render:...");
        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    }
});
