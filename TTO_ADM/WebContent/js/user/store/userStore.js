Ext.define('user.store.userStore', {
    extend: 'Ext.data.Store',

    requires: [
        'user.model.userModel'
    ],

    model: 'user.model.userModel',
	storeId: 'userStore',
	autoLoad:true,
	data:{'items':[
		{userId:'1',userPhone:'13750003000',isVendor:true},
		{userId:'2',userPhone:'13750003001',isVendor:true},
		{userId:'3',userPhone:'13750003002',isVendor:false},
		{userId:'4',userPhone:'13750003003',isVendor:false}
	]},
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});