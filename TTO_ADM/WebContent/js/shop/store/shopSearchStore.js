Ext.define('shop.store.shopSearchStore', {
    extend: 'Ext.data.Store',

    requires: [
        'shop.model.shopSearchModel'
    ],

    model: 'shop.model.shopSearchModel',
	storeId: 'shopSearchStore',
    proxy: {
    	type : 'ajax',
		url : 'load.do',
        reader : {
			type : 'json',
			root : 'datas',
			totalProperty : 'total'
		}
    }
});