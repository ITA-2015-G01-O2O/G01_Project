Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
	models : [ 
		'configModel'
	],
	stores : [ 
		'categoryStore'
	],
    views: [
        'searchView'
    ],
	controllers : [
		'searchController',
		'cmn.controller.cmnController'
	],
    name: 'config',
	appFolder: 'js/config',

    launch: function() {
        Ext.create('config.view.searchView');
    }

});
