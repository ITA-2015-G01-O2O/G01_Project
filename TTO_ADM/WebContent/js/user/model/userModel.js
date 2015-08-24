Ext.define('user.model.userModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
        	name: 'userId'
        },
        {
            name: 'userPhone'
        },
        {
            name: 'isVendor'
        }
    ]
});