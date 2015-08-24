Ext.define('shop.model.shopSearchModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
		{
        	name: 'shopId'
        },
        {
        	name: 'shopName'
        },
        {
            name: 'ownerName'
        },
        {
            name: 'locationName'
        },
        {
            name: 'isHot',
			type:'boolean'
        },
        {
            name: 'status'
        }
    ]
});