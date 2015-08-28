Ext.define('cmn.controller.cmnController', {
	extend : 'Ext.app.Controller',

	init : function(application) {
		this.control({
			'#userBtn':{
				click:this.userPage
			},
			'#shopBtn':{
				click:this.shopPage
			},
			'#systemBtn':{
				click:this.systemPage
			},
			'#logoutBtn':{
				click:this.logout
			},
			'#logoImg':{
				beforerender:this.loadLogo
			},
			'#titleLabel':{
				beforerender:this.loadSystemTitle
			}
		});
	},
	userPage:function(){
		window.location.href=domain_name+'user/userSearch.view';
	},
	logout:function(){
		Ext.Ajax.request({
			url : domain_name+'logout.do',
			success : function(response) {
				window.location.href=domain_name+'admin/login.view';
			},
			failure : function() {
				window.location.href=domain_name+'admin/login.view';
			}
		});
		
	},
	shopPage:function(){
		window.location.href=domain_name+'shop/shopSearch.view';
	},
	systemPage:function(){
		window.location.href=domain_name+'config/configView.view';
	},
	loadLogo:function( comp, eOpts ){
		comp.setSrc(domain_name+system_logo_src);
	},
	loadSystemTitle:function(comp,eOpts){
		comp.setText(system_title);
	}
});