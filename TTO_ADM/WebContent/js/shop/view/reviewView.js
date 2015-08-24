Ext.define('shop.view.reviewView', {
    extend: 'Ext.container.Viewport',

    itemId: 'reviewView',
    layout: 'border',

    initComponent: function() {
         var me = this;

        Ext.applyIf(me, {
			items:[
				{
					xtype: 'container',
					region:'north',
					cls:'paddingBox',
					items: [
						{
							xtype: 'label',
							cls: 'title',
							text: 'Shop View',
							id:'viewTitle',
							itemId:'viewTitle'
						}
					]
				},{
					xtype:'container',
					region:'center',
					items: [
						{
							xtype: 'panel',
							region: 'north',
							id:'vendorInfoPane',
							itemId: 'vendorInfoPane',
							title: 'Vendor Info',
							cls:'sadas',
							layout: {
								type: 'vbox',
								align: 'stretch'
							},
							items: [
								{
									xtype: 'container',
									layout:'vbox',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'Status',
											id:'statusField',
											itemId:'statusField'
										}
									]
								},
								{
									xtype: 'container',
									layout:'vbox',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'ID Card Number',
											id:'idCardNumberField',
											itemId:'idCardNumberField'
										}
									]
								},
								{
									xtype: 'container',
									layout:'vbox',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'Real Name',
											id:'realNameField',
											itemId:'realNameField'
										}
									]
								},
								{
									xtype: 'container',
									layout:'hbox',
									cls:'paddingBox',
									items: [
										{
											xtype:'container',
											layout:'vbox',
											cls:'paddingBox',
											items:[
												{
													xtype: 'label',
													text: 'ID Card Picture'
												},
												{
													xtype: 'image',
													src:'img/test.png',
													height: 175,
													width: 175,
													id:'idCardPicImg',
													itemId:'idCardPicImg'
												}
											]
										},{
											xtype:'container',
											layout:'vbox',
											cls:'paddingBox',
											items:[
												{
													xtype: 'label',
													text: 'License Picture'
												},
												{
													xtype: 'image',
													src:'img/test.png',
													height: 175,
													width: 175,
													id:'licensePicImg',
													itemId:'licensePicImg'
												}
											]
										},{
											xtype:'container',
											layout:'vbox',
											cls:'paddingBox',
											items:[
												{
													xtype: 'label',
													text: 'Real Shop Picture'
												},
												{
													xtype: 'image',
													src:'img/test.png',
													height: 175,
													width: 175,
													id:'realShopPicImg',
													itemId:'realShopPicImg'
												}
											]
										}
									]
								}
							],
							dockedItems: [
								{
									xtype: 'toolbar',
									dock: 'top',
									items: [
										{
											xtype: 'button',
											text: 'Active Vendor',
											id:'activeBtn',
											itemId:'activeBtn',
											disabled:true
										},
										{
											xtype: 'button',
											text: 'Inactive Vendor',
											id:'inactiveBtn',
											itemId:'inactiveBtn',
											disabled:true
										}
									]
								}
							]
						},
						{
							xtype: 'panel',
							region: 'center',
							itemId: 'contentPanel',
							title: 'Stop Info',
							items: [
								{
									xtype:'container',
									layout:'vbox',
									cls:'paddingBox',
									items:[
										{
											xtype: 'label',
											text: 'Shop Logo'
										},
										{
											xtype: 'image',
											src:'img/test.png',
											height: 175,
											width: 175,
											id:'shopLogoPicImg',
											itemId:'shopLogoPicImg'
										}
									]
								},{
									xtype: 'container',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'Shop name',
											id:'shopNameField',
											itemId:'shopNameField'
										}
									]
								},{
									xtype: 'container',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'Location name',
											id:'locationNameField',
											itemId:'locationNameField'
										}
									]
								},{
									xtype: 'container',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'service time',
											id:'serviceTimeField',
											itemId:'serviceTimeField'
										}
									]
								},{
									xtype: 'container',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'deliver fee',
											renderer:function(val){
												if(Ext.isEmpty(val)){
													return "$"+0;
												}else{
													return "$"+val;
												}
											},
											id:'deliverFeeField',
											itemId:'deliverFeeField'
										}
									]
								},{
									xtype: 'container',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'starting fee',
											renderer:function(val){
												if(Ext.isEmpty(val)){
													return "$"+0;
												}else{
													return "$"+val;
												}
											},
											id:'startingFeeField',
											itemId:'startingFeeField'
										}
									]
								},{
									xtype: 'container',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'avg point',
											renderer:function(val){
												if(Ext.isEmpty(val)){
													return 0+" point";
												}else{
													return val+" point";
												}
											},
											id:'avgPointField',
											itemId:'avgPointField'
										}
									]
								},{
									xtype: 'container',
									cls:'paddingBox',
									items: [
										{
											xtype: 'displayfield',
											fieldLabel: 'avg deliver time',
											renderer:function(val){
												if(Ext.isEmpty(val)){
													return 0+" min";
												}else{
													return val+" min";
												}
											},
											id:'avgDeliverField',
											itemId:'avgDeliverField'
										}
									]
								}
							],
							dockedItems: [
								{
									xtype: 'toolbar',
									dock: 'bottom',
									layout: {
										type: 'hbox',
										pack: 'end'
									},
									items: [
										{
											xtype: 'button',
											text: 'Close',
											cls:'closeBtn',
											id:'closeBtn',
											itemId:'closeBtn'
										}
									]
								}
							]
						}
					]
				}
			]
			
            
        });

        me.callParent(arguments);
    }

});