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