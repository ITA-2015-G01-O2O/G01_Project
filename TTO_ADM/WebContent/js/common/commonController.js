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
		window.location.href='/TTO_Admin/user/userSearch.view';
	},
	logout:function(){
		Ext.Ajax.request({
			url : '/TTO_Admin/logout.do',
			success : function(response) {
				window.location.href='/TTO_Admin/admin/login.view';
			},
			failure : function() {
				window.location.href='/TTO_Admin/admin/login.view';
			}
		});
		
	},
	shopPage:function(){
		window.location.href='/TTO_Admin/shop/shopSearch.view';
	},
	systemPage:function(){
		window.location.href='/TTO_Admin/config/configView.view';
	},
	loadLogo:function( comp, eOpts ){
		comp.setSrc('/TTO_Admin/img/rice.png');
	},
	loadSystemTitle:function(comp,eOpts){
		comp.setText('Tomcat Takeout Admin');
	}
});