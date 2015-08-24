Ext.define('login.controller.loginController', {
	extend : 'Ext.app.Controller',

	init : function(application) {
		this.control({
			'#loginBtn' : {
				click : this.login
			},
			"#loginView textfield" : {
				blur : this.toTrimValue
			},
		});
	},
	toTrimValue : function(comp) {
		if (Ext.typeOf(comp.getValue()) == 'string') {
			comp.setValue(Ext.String.trim(comp.getValue()));
		}
	},
	login : function() {
		var loginname = Ext.getCmp('loginname').getValue();
		var password = Ext.getCmp('password').getValue();
		Ext.getBody().mask();
		Ext.Ajax.request({
			url : 'login.do',
			params : {
				loginname : loginname,
				password : password
			},
			success : function(res) {
				var jsonResult = Ext.util.JSON.decode(res.responseText);
				console.log(jsonResult);
				Ext.getBody().unmask();
			},
			failure : function() {
				Ext.getBody().unmask();
			}
		});
	}
});