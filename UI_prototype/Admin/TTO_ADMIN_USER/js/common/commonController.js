Ext.define('cmn.controller.cmnController', {
	extend : 'Ext.app.Controller',

	init : function(application) {
		this.control({
			'#userBtn':{
				click:this.userPage
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
	loadLogo:function( comp, eOpts ){
		comp.setSrc('img/rice.png');
	},
	loadSystemTitle:function(comp,eOpts){
		comp.setText('Tomcat Takeout Admin');
	}
});