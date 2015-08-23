Ext.define('shop.store.statusStore', {
    extend: 'Ext.data.Store',

    requires: [
        'shop.model.statusModel'
    ],

    model: 'shop.model.statusModel',
	storeId: 'statusStore',
	autoLoad:true,
	data:{'items':[
		{statusName:'normal',statusId:'1'},
		{statusName:'check',statusId:'2'},
		{statusName:'freeze',statusId:'3'}
	]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});