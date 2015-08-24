Ext.define('shop.store.shopSearchStore', {
    extend: 'Ext.data.Store',

    requires: [
        'shop.model.shopSearchModel'
    ],

    model: 'shop.model.shopSearchModel',
	storeId: 'shopSearchStore',
	autoLoad:true,
	data:{'items':[
		{shopId:1,shopName:'test shop 1',ownerName:'test owner name1',isHot:false,status:'normal',locationName:'test location 1'},
		{shopId:2,shopName:'test shop 2',ownerName:'test owner name2',isHot:false,status:'check',locationName:'test location 2'},
		{shopId:3,shopName:'test shop 3',ownerName:'test owner name3',isHot:false,status:'freeze',locationName:'test location 3'},
		{shopId:4,shopName:'test shop 4',ownerName:'test owner name4',isHot:true,status:'normal',locationName:'test location 4'}
	]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});