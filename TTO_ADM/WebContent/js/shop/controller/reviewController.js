Ext.define('shop.controller.reviewController', {
	extend : 'Ext.app.Controller',
	shopDTO : {},

	init : function(application) {
		this.control({
			'#reviewView' : {
				afterrender : this.loadData
			},
			'#activeBtn' : {
				click : this.activeShop
			},
			'#inactiveBtn' : {
				click : this.inactiveShop
			},
			'#closeBtn' : {
				click : this.closeWin
			}
		});
	},
	closeWin : function() {
		window.close();
	},
	activeShop : function() {
		var me=this;
		Ext.Ajax.request({
			url : 'active.do',
			params : {
				id : me.shopDTO.shopId
			},
			success : function(response) {
				me.loadData();
				Ext.MessageBox.alert('Tip', 'Success');
				Ext.getBody().unmask();
			},
			failure : function() {
				Ext.MessageBox.alert('Tip', 'Error');
				Ext.getBody().unmask();
			}
		});
	},
	inactiveShop : function() {
		var me=this;
		Ext.Ajax.request({
			url : 'inactive.do',
			params : {
				id : me.shopDTO.shopId
			},
			success : function(response) {
				me.loadData();
				Ext.MessageBox.alert('Tip', 'Success');
				Ext.getBody().unmask();
			},
			failure : function() {
				Ext.MessageBox.alert('Tip', 'Error');
				Ext.getBody().unmask();
			}
		});
	},
	loadData : function(comp, eOpts) {
		var me = this;
		var shopId=document.getElementById("shopId").value;
		Ext.Ajax.request({
			url : 'getDetail.do',
			params : {
				id : shopId
			},
			success : function(response) {
				me.shopDTO = Ext.decode(response.responseText);
				Ext.getCmp('statusField').setValue(me.shopDTO.status);
				Ext.getCmp('idCardNumberField').setValue(me.shopDTO.idcardNumber);
				Ext.getCmp('realNameField').setValue(me.shopDTO.realName);
				Ext.getCmp('idCardPicImg').setSrc(me.shopDTO.idcardPicUrl);
				Ext.getCmp('licensePicImg').setSrc(me.shopDTO.licensePicImg);
				Ext.getCmp('realShopPicImg').setSrc(me.shopDTO.realShopPicUrl);

				Ext.getCmp('shopNameField').setValue(me.shopDTO.shopName);
				Ext.getCmp('locationNameField').setValue(me.shopDTO.locationName);
				Ext.getCmp('deliverFeeField').setValue(me.shopDTO.deliverFee);
				Ext.getCmp('startingFeeField').setValue(me.shopDTO.startingFee);
				Ext.getCmp('avgPointField').setValue(me.shopDTO.avgPoint);
				Ext.getCmp('avgDeliverField').setValue(me.shopDTO.avgDeliverTime);
				Ext.getCmp('shopLogoPicImg').setSrc(me.shopDTO.logoPicUrl);

				Ext.getCmp('serviceTimeField').setValue(
						me.shopDTO.serviceBeginTime + ' to '
								+ me.shopDTO.serviceEndTime);

				Ext.getCmp('activeBtn').setDisabled(!me.shopDTO.canActive);
				Ext.getCmp('inactiveBtn').setDisabled(!me.shopDTO.canInActive);
				Ext.getBody().unmask();
			},
			failure : function() {
				Ext.MessageBox.alert('Tip', 'Error');
				Ext.getBody().unmask();
			}
		});
	}
});