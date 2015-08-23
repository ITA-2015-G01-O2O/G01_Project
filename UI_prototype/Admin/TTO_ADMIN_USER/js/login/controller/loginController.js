Ext.define('login.controller.loginController', {
	extend : 'Ext.app.Controller',

	init : function(application) {
		this.control({
			'#loginBtn':{
				click:this.login
			},
			"#loginView textfield":{
				blur: this.toTrimValue
			},
		});
	},
	toTrimValue:function(comp){
		if(Ext.typeOf(comp.getValue())=='string'){
			comp.setValue(Ext.String.trim(comp.getValue()));
		}
	},
	login:function(){
		var username = Ext.getCmp('loginname').getValue();
		var password = Ext.getCmp('password').getValue();
		Ext.MessageBox.alert('test',username+":"+password,function(){
			window.location.href='userView.html';
		});
	}
});