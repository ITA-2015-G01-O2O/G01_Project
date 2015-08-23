Ext.define('shop.controller.searchController', {
	extend : 'Ext.app.Controller',

	init : function(application) {
		this.control({
			'#searchBtn':{
				click:this.search
			},
			'#resetPswBtn':{
				click:this.resetPsw
			},
			"#searchView textfield":{
				blur: this.toTrimValue
			},
			'#setAsHotShopBtn':{
				click:this.setAsHotShop
			},
			'#viewBtn':{
				click:this.viewShop
			}
		});
	},
	toTrimValue:function(comp){
		if(Ext.typeOf(comp.getValue())=='string'){
			comp.setValue(Ext.String.trim(comp.getValue()));
		}
	},
	search:function(){
		var stopName = Ext.getCmp('searchStopName').getValue();
		var isHot = Ext.getCmp('searchIsHot').getValue();
		var location = Ext.getCmp('searchLocation').getValue();
		var status = Ext.getCmp('searchStatus').getValue();
		Ext.MessageBox.alert('test',stopName+":"+isHot+":"+location+":"+status);
	},
	setAsHotShop:function(){
		var searchResultGrid = Ext.getCmp('searchResultGrid');
		var selectedRows = searchResultGrid.getSelectionModel().getSelection();
		if(selectedRows.length==1){
			Ext.MessageBox.confirm('Confirm', 'Are you sure?',function(btn, text){
				if (btn == 'yes'){
					var shopId=selectedRows[0].data.shopId;
					Ext.MessageBox.alert('test','id:'+shopId);	
				}
			});
		}
	},
	viewShop:function(){
		var searchResultGrid = Ext.getCmp('searchResultGrid');
		var selectedRows = searchResultGrid.getSelectionModel().getSelection();
		if(selectedRows.length==1){
			var shopId=selectedRows[0].data.shopId;
			Ext.MessageBox.alert('test','id:'+shopId);	
		}
	}
});