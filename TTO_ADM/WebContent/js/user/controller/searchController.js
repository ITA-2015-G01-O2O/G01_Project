Ext.define('user.controller.searchController', {
	extend : 'Ext.app.Controller',

	init : function(application) {
		this.control({
			'#searchBtn' : {
				click : this.search
			},
			'#resetPswBtn' : {
				click : this.resetPsw
			},
			"#searchView textfield" : {
				blur : this.toTrimValue
			},
		});
	},
	toTrimValue : function(comp) {
		if (Ext.typeOf(comp.getValue()) == 'string') {
			comp.setValue(Ext.String.trim(comp.getValue()));
		}
	},
	search : function() {
		var userPhone = Ext.getCmp('searchUserPhone').getValue();
		var vendor = Ext.getCmp('searchIsVendor').getValue();

		var store = Ext.getCmp('searchResultGrid').getStore();
		store.load({
			params : {
				start : 0,
				userPhone : userPhone,
				isVendor : vendor
			}
		});
	},
	resetPsw : function() {
		Ext.MessageBox.confirm('Confirm', 'Are you sure?', function(btn, text) {
			if (btn == 'yes') {
				var searchResultGrid = Ext.getCmp('searchResultGrid');
				var selectedRows = searchResultGrid.getSelectionModel()
						.getSelection();
				if (selectedRows.length == 1) {
					var userId = selectedRows[0].data.userId;
					Ext.getBody().mask();
					Ext.Ajax.request({
						url : 'resetPsw.do',
						params : {
							id : userId
						},
						success : function(response) {
							var responseData = Ext.decode(response.responseText);
							Ext.getBody().unmask();
							Ext.MessageBox.alert('Tip', 'New Password:'+responseData.data);
						},
						failure : function() {
							Ext.getBody().unmask();
						}
					});
				}
			}
		});
	}
});