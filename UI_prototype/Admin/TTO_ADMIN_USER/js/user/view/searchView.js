Ext.define('user.view.searchView', {
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
        'Ext.toolbar.Paging',
		'user.store.userStore'
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
                                    fieldLabel: 'user phone',
									id:'searchUserPhone',
									itemId:'searchUserPhone'
                                },
                                {
                                    xtype: 'checkboxfield',
                                    anchor: '100%',
                                    fieldLabel: 'Is Vendor?',
                                    boxLabel: 'Yes',
									inputValue:true,
									id:'searchIsVendor',
									itemId:'searchIsVendor'
                                },
                                {
                                    xtype: 'button',
                                    text: 'Seach',
									itemId:'searchBtn'
                                }
                            ]
                        },
                        {
                            xtype: 'gridpanel',
                            region: 'center',
                            title: 'Use List',
							enableColumnHide : false,
							sortableColumns : false,
							store: 'userStore',
							id:'searchResultGrid',
							itemId: 'searchResultGrid',
                            columns: [
                                {
                                    xtype: 'gridcolumn',
                                    text: 'User Phone',
									minWidth: 250,
									dataIndex: 'userPhone',
									renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
										return record.data.userPhone;
									}
                                },
                                {
                                    xtype: 'gridcolumn',
                                    text: 'Is Vendor',
									minWidth: 250,
									dataIndex: 'isVendor',
									renderer: function(value, metaData, record, rowIndex, colIndex, store, view) {
										return record.data.isVendor;
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
                                            text: 'Reset Password',
											itemId:'resetPswBtn',
											cls:'highlightBtn'
                                        }
                                    ]
                                },
                                {
                                    xtype: 'pagingtoolbar',
                                    dock: 'bottom',
									store: 'userStore',
                                    width: 360,
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
                                    text: 'User Manager'
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