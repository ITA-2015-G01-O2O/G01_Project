Ext.define('shop.store.statusStore', {
    extend: 'Ext.data.Store',

    requires: [
        'shop.model.statusModel'
    ],

    model: 'shop.model.statusModel',
	storeId: 'statusStore',
	autoLoad:true,
	data:{'items':[
		{statusName:'normal',statusId:'NORMAL'},
		{statusName:'check',statusId:'CHECK'},
		{statusName:'freeze',statusId:'FREEZE'}
	]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});