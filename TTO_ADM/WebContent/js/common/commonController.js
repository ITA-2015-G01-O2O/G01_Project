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
		window.location.href='userSearch.html';
	},
	shopPage:function(){
		window.location.href='shopSearch.html';
	},
	systemPage:function(){
		window.location.href='configView.html';
	},
	loadLogo:function( comp, eOpts ){
		comp.setSrc('/TTO_Admin/img/rice.png');
	},
	loadSystemTitle:function(comp,eOpts){
		comp.setText('Tomcat Takeout Admin');
	}
});