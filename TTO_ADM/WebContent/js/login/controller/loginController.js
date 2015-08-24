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
			success : function(response) {
				var responseData = Ext.decode(response.responseText);
				Ext.getBody().unmask();
				if(!responseData.isSuccess){
					var tip='';
					if(responseData.data=='tip.error.psw'){
						tip='password error!';
					}else if(responseData.data=='tip.error.login'){
						tip='this account has logined';
					}else if(responseData.data=='tip.error.nofound'){
						tip='the acccount has been not found!';
					}
					Ext.MessageBox.alert('Error', tip);
				}else{
					window.location.href='../user/userSearch.view';
				}
			},
			failure : function() {
				Ext.getBody().unmask();
			}
		});
	}
});