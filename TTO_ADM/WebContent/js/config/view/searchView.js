Ext.define('config.view.searchView', {
    extend: 'Ext.container.Viewport',
	
    itemId: 'searchView',
    layout: 'border',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'panel',
                    region: 'north',
                    height: 105,
                    layout: 'column',
                    bodyCls: 'margeBox',
                    header: false,
                    items: [
                        {
                            xtype: 'image',
                            height: 75,
                            width: 75,
							id:'logoImg',
							itemId:'logoImg'
                        },
                        {
                            xtype: 'container',
                            items: [
                                {
                                    xtype: 'label',
                                    cls: 'title',
                                    height: 75,
									id:'titleLabel',
									itemId:'titleLabel'
                                }
                            ]
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'toolbar',
                            dock: 'bottom',
                            items: [
                                {
                                    xtype: 'button',
                                    text: 'User',
									id:'userBtn',
									itemId:'userBtn'
                                },
                                {
                                    xtype: 'button',
                                    text: 'Shop',
									id:'shopBtn',
									itemId:'shopBtn'
                                },
                                {
                                    xtype: 'button',
                                    text: 'System',
									id:'systemBtn',
									itemId:'systemBtn'
                                },
                                { 
                                	xtype: 'tbspacer',
                                	width:50
                                },
                                { 
                                	xtype: 'tbseparator' 
                                },
                                {
                                    xtype: 'button',
                                    text: 'Logout',
									id:'logoutBtn',
									itemId:'logoutBtn'
                                }
                            ]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    flex: 1,
                    region: 'center',
                    itemId: 'contentPanel',
                    layout: 'border',
                    bodyBorder: true,
                    bodyCls: 'paddingBox',
                    items: [
                        {
							xtype: 'panel',
							region: 'center',
							itemId: 'contentPanel',
							bodyPadding: 10,
							title: 'System Config',
							items: [
								{
									xtype: 'textfield',
									fieldLabel: 'Service hot line',
									allowBlank: false,
									id:'serviceHotLine',
									itemId:'serviceHotLineFiled'
								},
								{
									xtype: 'numberfield',
									fieldLabel: 'Order Auto Confirm Time',
									regex: /^[A-Za-z0-9]+$/,
									allowBlank: false,
									enforceMaxLength: true,
									maxLength: 2,
									maxValue: 24,
									minValue: 1,
									value:1,
									id:'orderAutoConfirmFiled',
									itemId:'orderAutoConfirmFiled'
								},
								{
									xtype: 'numberfield',
									fieldLabel: 'Order Auto Cancel Time',
									allowBlank: false,
									regex: /^[A-Za-z0-9]+$/,
									enforceMaxLength: true,
									maxLength: 2,
									maxValue: 24,
									minValue: 1,
									value:1,
									id:'orderAutoCancelFiled',
									itemId:'orderAutoCancelFiled'
								},
								{
									xtype: 'gridpanel',
									enableColumnHide : false,
									sortableColumns : false,
									store:'categoryStore',
									id:'categoryList',
									itemId:'categoryList',
									emptyText:'No Category',
									columns: [
										{
											xtype: 'gridcolumn',
											dataIndex: 'configValue',
											minWidth: 250,
											text: 'Category Name',
											renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
												return record.data.configValue;
											},
											editor:{
												xtype:'textfield'
											}  
										}
									],
									selModel: Ext.create('Ext.selection.CheckboxModel', {
										mode:'SINGLE'
									}),
									dockedItems: [
										{
											xtype: 'toolbar',
											dock: 'top',
											items: [
												{
													xtype: 'button',
													text: 'Add',
													itemId:'addBtn'
												},{
													xtype: 'button',
													text: 'Delete',
													disabled:true,
													id:'deleteBtn',
													itemId:'deleteBtn'
												}
											]
										}
									],
									plugins: [   
										Ext.create('Ext.grid.plugin.CellEditing', {
											clicksToEdit: 1  
										})
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
											text: 'Save Config',
											itemId:'saveConfigBtn'
										},{
											xtype: 'button',
											text: 'Refresh Config',
											itemId:'refreshConfigBtn'
										}
									]
								}
							]
						}
                    ],
                    dockedItems: [
                        {
                            xtype: 'container',
                            dock: 'top',
                            cls: 'paddingBox',
                            items: [
                                {
                                    xtype: 'label',
                                    cls: 'title',
                                    text: 'System Config'
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