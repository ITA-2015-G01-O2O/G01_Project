Ext.define('config.store.categoryStore', {
    extend: 'Ext.data.Store',

    model: 'config.model.configModel',
	storeId: 'categoryStore',
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    }
});