Ext.define('shop.controller.searchController', {
	extend : 'Ext.app.Controller',

	init : function(application) {
		this.control({
			'#searchResultGrid' : {
				selectionchange : this.checkButtonAccess
			},
			'#searchBtn' : {
				click : this.search
			},
			'#resetPswBtn' : {
				click : this.resetPsw
			},
			"#searchView textfield" : {
				blur : this.toTrimValue
			},
			'#setAsHotShopBtn' : {
				click : this.setAsHotShop
			},
			'#cancelAsHotShopBtn' : {
				click : this.cancelAsHotShop
			},
			'#viewBtn' : {
				click : this.viewShop
			},
			'#resetBtn' : {
				click : this.reset
			},
			'#checkTipLabel':{
				afterrender:this.refreshCheckTotal
			}
		});
	},
	toTrimValue : function(comp) {
		if (Ext.typeOf(comp.getValue()) == 'string') {
			comp.setValue(Ext.String.trim(comp.getValue()));
		}
	},
	refreshCheckTotal:function(){
		Ext.Ajax.request({
			url : 'getCheckStatusTotal.do',
			success : function(response) {
				Ext.getCmp('checkTipLabel').setText(Ext.decode(response.responseText).data);
				scrollTimer = setInterval(function() {
					Ext.Ajax.request({
						url : 'getCheckStatusTotal.do',
						success : function(response) {
							Ext.getCmp('checkTipLabel').setText(Ext.decode(response.responseText).data);
						},
						failure : function() {}
					});
				}, 30000);
			},
			failure : function() {}
		});
	},
	reset:function(){
		Ext.getCmp('searchStopName').reset();
		Ext.getCmp('searchIsHot').reset();
		Ext.getCmp('searchLocation').reset();
		Ext.getCmp('searchStatus').reset();
	},
	checkButtonAccess : function() {
		var grid = Ext.getCmp('searchResultGrid');
		var selectedRows = grid.getSelectionModel().getSelection();
		if (selectedRows.length == 1) {
			if (selectedRows[0].data.status=='NORMAL' && selectedRows[0].data.isHot) {
				Ext.getCmp('setAsHotShopBtn').setDisabled(true);
				Ext.getCmp('cancelAsHotShopBtn').setDisabled(false);
			} else if(selectedRows[0].data.status=='NORMAL'){
				Ext.getCmp('setAsHotShopBtn').setDisabled(false);
				Ext.getCmp('cancelAsHotShopBtn').setDisabled(true);
			}
			Ext.getCmp('viewBtn').setDisabled(false);
		} else {
			Ext.getCmp('setAsHotShopBtn').setDisabled(true);
			Ext.getCmp('cancelAsHotShopBtn').setDisabled(true);
			Ext.getCmp('viewBtn').setDisabled(true);
		}
	},
	search : function() {
		var stopName = Ext.getCmp('searchStopName').getValue();
		var isHot = Ext.getCmp('searchIsHot').getValue();
		var location = Ext.getCmp('searchLocation').getValue();
		var status = Ext.getCmp('searchStatus').getValue();

		var store = Ext.getCmp('searchResultGrid').getStore();
		store.load({
			params : {
				start : 0,
				stopName : stopName,
				isHot : isHot,
				locationId : location,
				status : status
			}
		});
	},
	setAsHotShop : function() {
		var searchResultGrid = Ext.getCmp('searchResultGrid');
		var selectedRows = searchResultGrid.getSelectionModel().getSelection();
		var me = this;
		if (selectedRows.length == 1) {
			Ext.MessageBox.confirm('Confirm', 'Are you sure?', function(btn,
					text) {
				if (btn == 'yes') {
					var shopId = selectedRows[0].data.shopId;
					Ext.getBody().mask();
					Ext.Ajax.request({
						url : 'setHot.do',
						params : {
							id : shopId
						},
						success : function(response) {
							Ext.MessageBox.alert('Tip', 'Success');
							Ext.getBody().unmask();
							me.reloadData();
						},
						failure : function() {
							Ext.MessageBox.alert('Tip', 'Error');
							Ext.getBody().unmask();
							me.reloadData();
						}
					});
				}
			});
		}
	},
	cancelAsHotShop : function() {
		var searchResultGrid = Ext.getCmp('searchResultGrid');
		var selectedRows = searchResultGrid.getSelectionModel().getSelection();
		var me = this;
		if (selectedRows.length == 1) {
			Ext.MessageBox.confirm('Confirm', 'Are you sure?', function(btn,
					text) {
				if (btn == 'yes') {
					var shopId = selectedRows[0].data.shopId;
					Ext.Ajax.request({
						url : 'setNoHot.do',
						params : {
							id : shopId
						},
						success : function(response) {
							Ext.MessageBox.alert('Tip', 'Success');
							Ext.getBody().unmask();
							me.reloadData();
						},
						failure : function() {
							Ext.MessageBox.alert('Tip', 'Error');
							Ext.getBody().unmask();
							me.reloadData();
						}
					});
				}
			});
		}
	},
	viewShop : function() {
		var searchResultGrid = Ext.getCmp('searchResultGrid');
		var selectedRows = searchResultGrid.getSelectionModel().getSelection();
		if (selectedRows.length == 1) {
			var shopId = selectedRows[0].data.shopId;
			window.open("detail.view?id=" + shopId);
		}
	},
	reloadData : function() {
		var store = Ext.getCmp('searchResultGrid').getStore();
		store.reload();
	}
});