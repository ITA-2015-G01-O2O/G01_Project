Ext.define('shop.store.locationStore', {
    extend: 'Ext.data.Store',

    requires: [
        'shop.model.locationModel'
    ],

    model: 'shop.model.locationModel',
	storeId: 'locationStore',
    proxy: {
    	type : 'ajax',
		url : 'loadLocation.do',
        reader : {
			type : 'json',
			root : 'data'
		}
    }
});