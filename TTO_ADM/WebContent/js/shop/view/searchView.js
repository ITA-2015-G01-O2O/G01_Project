Ext.define('shop.view.searchView', {
    extend: 'Ext.container.Viewport',

    requires: [
        'Ext.Img',
        'Ext.form.Label',
        'Ext.button.Button',
        'Ext.form.field.Text',
        'Ext.form.field.Checkbox',
        'Ext.grid.Panel',
        'Ext.grid.column.Boolean',
        'Ext.grid.View',
        'Ext.toolbar.Paging'
    ],

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
                            region: 'north',
                            layout: 'anchor',
                            bodyCls: 'paddingBox',
                            collapsible: true,
                            title: 'Seach',
                            items: [
                                {
                                    xtype: 'textfield',
                                    fieldLabel: 'stop name',
									id:'searchStopName',
									itemId:'searchStopName'
                                },
                                {
                                    xtype: 'checkboxfield',
                                    anchor: '100%',
                                    fieldLabel: 'Is Hot?',
                                    boxLabel: 'Yes',
									inputValue:true,
									id:'searchIsHot',
									itemId:'searchIsHot'
                                },{
                                    xtype: 'combobox',
                                    fieldLabel: 'location',
									store:'locationStore',
									//queryModel:'local',
									displayField: 'locationName',
									valueField: 'locationId',
									forceSelection: true,
									hideTrigger :true,
									minChars:3,
									id:'searchLocation',
									itemId:'searchLocation',
									value:'NORMAL'
                                },{
                                    xtype: 'combobox',
                                    fieldLabel: 'status',
									store:'statusStore',
									queryModel:'local',
									displayField: 'statusName',
									valueField: 'statusId',
									forceSelection: true,
									id:'searchStatus',
									itemId:'searchStatus'
                                },
                                {
                                    xtype: 'button',
                                    text: 'Seach',
									itemId:'searchBtn'
                                },
                                {
                                    xtype: 'button',
                                    text: 'reset',
									itemId:'resetBtn'
                                }
                            ]
                        },
                        {
                            xtype: 'gridpanel',
                            region: 'center',
                            title: 'Use List',
							enableColumnHide : false,
							sortableColumns : false,
							store: 'shopSearchStore',
							id:'searchResultGrid',
							itemId: 'searchResultGrid',
							emptyText:'No Result Found',
                            columns: [
                                {
                                    xtype: 'gridcolumn',
                                    text: 'Shop Name',
									minWidth: 250,
									dataIndex: 'shopName',
									renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
										return record.data.shopName;
									}
                                },{
                                    xtype: 'gridcolumn',
                                    text: 'Owner Name',
									minWidth: 250,
									dataIndex: 'ownerName',
									renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
										return record.data.ownerName;
									}
                                },{
                                    xtype: 'gridcolumn',
                                    text: 'Location Name',
									minWidth: 250,
									dataIndex: 'locationName',
									renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
										return record.data.locationName;
									}
                                },{
                                    xtype: 'gridcolumn',
                                    text: 'Is Hot',
									minWidth: 250,
									dataIndex: 'isHot',
									renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
										if(record.data.isHot){
											return 'Y';
										}else{
											return 'N';
										}
									}
                                },{
                                    xtype: 'gridcolumn',
                                    text: 'Status',
									minWidth: 250,
									dataIndex: 'status',
									renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
										return record.data.status;
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
                                            text: 'Set As Hot Shop',
                                            id:'setAsHotShopBtn',
											itemId:'setAsHotShopBtn',
											disabled:true
                                        },{
                                            xtype: 'button',
                                            text: 'Cancel Hot Shop',
                                            id:'cancelAsHotShopBtn',
											itemId:'cancelAsHotShopBtn',
											disabled:true
                                        },{
                                            xtype: 'button',
                                            text: 'View & Change Status',
											itemId:'viewBtn'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'pagingtoolbar',
                                    dock: 'bottom',
                                    width: 360,
									store:'shopSearchStore',
                                    displayInfo: true
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
                                    text: 'Shop Manager'
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