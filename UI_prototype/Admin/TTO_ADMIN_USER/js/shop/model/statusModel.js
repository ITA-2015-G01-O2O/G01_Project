Ext.define('shop.model.statusModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
        	name: 'statusName'
        },
        {
            name: 'statusId'
        }
    ]
});