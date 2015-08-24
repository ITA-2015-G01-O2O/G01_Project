Ext.define('login.view.loginView', {
    extend: 'Ext.container.Viewport',
    alias: 'widget.mainviewport',

    requires: [
        'Ext.form.Panel',
        'Ext.form.field.ComboBox',
        'Ext.button.Button'
    ],

    layout: {
        type: 'hbox',
        align: 'middle',
        pack: 'center'
    },
	
	itemId:'loginView',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    itemId: 'form',
                    width: 500,
                    bodyPadding: 10,
                    title: 'Login TTO Admin',
                    items: [
                        {
                            xtype: 'textfield',
                            anchor: '100%',
							id:'loginname',
                            itemId: 'loginname',
                            fieldLabel: 'Login Name',
							allowBlank: false,
                            labelAlign: 'right',
                            labelWidth: 70
                        },
						{
                            xtype: 'textfield',
                            anchor: '100%',
							id:'password',
                            itemId: 'password',
                            fieldLabel: 'Password',
							allowBlank: false,
                            labelAlign: 'right',
                            labelWidth: 70
                        },
                        {
                            xtype: 'container',
                            margin: '10 0 10 0',
                            layout: {
                                type: 'hbox',
                                align: 'middle',
                                pack: 'center'
                            },
                            items: [
                                {
                                    xtype: 'button',
                                    itemId: 'loginBtn',
                                    text: 'Login'
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