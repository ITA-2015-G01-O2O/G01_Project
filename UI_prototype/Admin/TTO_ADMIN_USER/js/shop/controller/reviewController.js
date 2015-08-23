Ext.define('shop.controller.reviewController', {
	extend : 'Ext.app.Controller',
	shopDTO:{},
	
	init : function(application) {
		this.control({
			'#reviewView':{
				afterrender:this.loadData
			},
			'#activeBtn':{
				click:this.activeShop
			},
			'#inactiveBtn':{
				click:this.inactiveShop
			},
			'#closeBtn':{
				click:this.closeWin
			}
		});
	},
	closeWin:function(){
		window.close();
	},
	activeShop:function(){
		Ext.MessageBox.alert('test','id:'+this.shopDTO.shopId);	
	},
	inactiveBtn:function(){
		Ext.MessageBox.alert('test','id:'+this.shopDTO.shopId);		
	},
	loadData:function( comp, eOpts ){
		this.shopDTO={
			shopId:'1',
			status:'Normal',
			idcardNumber:'610103199310101010',
			realName:'test real name',
			idcardPicUrl:'img/test.png',
			licensePicImg:'img/test.png',
			realShopPicUrl:'img/test.png',
			canActive:false,
			canInActive:true,
			shopName:'test shop name',
			locationName:'test location name',
			serviceBeginTime:'10:00',
			serviceEndTime:'19:00',
			deliverFee:'10',
			startingFee:'10',
			avgPoint:'10',
			avgDeliverTime:'10',
			logoPicUrl:'img/test.png'
		};
		
		Ext.getCmp('statusField').setValue(this.shopDTO.status);
		Ext.getCmp('idCardNumberField').setValue(this.shopDTO.idcardNumber);
		Ext.getCmp('realNameField').setValue(this.shopDTO.realName);
		Ext.getCmp('idCardPicImg').setSrc(this.shopDTO.idcardPicUrl);
		Ext.getCmp('licensePicImg').setSrc(this.shopDTO.licensePicImg);
		Ext.getCmp('realShopPicImg').setSrc(this.shopDTO.realShopPicUrl);
		
		
		Ext.getCmp('shopNameField').setValue(this.shopDTO.shopName);
		Ext.getCmp('locationNameField').setValue(this.shopDTO.locationName);
		Ext.getCmp('deliverFeeField').setValue(this.shopDTO.deliverFee);
		Ext.getCmp('startingFeeField').setValue(this.shopDTO.startingFee);
		Ext.getCmp('avgPointField').setValue(this.shopDTO.avgPoint);
		Ext.getCmp('avgDeliverField').setValue(this.shopDTO.avgDeliverTime);
		Ext.getCmp('shopLogoPicImg').setSrc(this.shopDTO.logoPicUrl);
		
		Ext.getCmp('serviceTimeField').setValue(this.shopDTO.serviceBeginTime+' to '+this.shopDTO.serviceEndTime);
		
		Ext.getCmp('activeBtn').setDisabled(this.shopDTO.canActive);
		Ext.getCmp('inactiveBtn').setDisabled(this.shopDTO.canInActive);

	}
});