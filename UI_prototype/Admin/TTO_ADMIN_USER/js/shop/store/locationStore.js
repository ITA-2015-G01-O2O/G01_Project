Ext.define('shop.store.locationStore', {
    extend: 'Ext.data.Store',

    requires: [
        'shop.model.locationModel'
    ],

    model: 'shop.model.locationModel',
	storeId: 'locationStore',
	autoLoad:true,
	data:{'items':[
		{locationName:'test location 1',locationId:'1'},
		{locationName:'test location 2',locationId:'2'},
		{locationName:'test location 3',locationId:'3'},
		{locationName:'test location 4',locationId:'4'},
		{locationName:'test location 5',locationId:'5'}
	]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});