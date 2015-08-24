Ext.define('user.store.userStore', {
	extend : 'Ext.data.Store',

	requires : [ 'user.model.userModel' ],

	model : 'user.model.userModel',
	storeId : 'userStore',
	proxy : {
		type : 'ajax',
		url : 'load.do',
		reader : {
			type : 'json',
			root : 'datas',
			totalProperty : 'total'
		}
	}
});