Ext.define('shop.model.locationModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
        	name: 'locationName'
        },
        {
            name: 'locationId'
        }
    ]
});