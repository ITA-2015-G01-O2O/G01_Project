Ext.define('config.store.categoryStore', {
    extend: 'Ext.data.Store',

    model: 'config.model.configModel',
	storeId: 'categoryStore',
	remoteSort:false,
    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root: 'items'
        }
    },
    sorters:[
      {property:'configValue',direction:'ASC'}
    ]
});