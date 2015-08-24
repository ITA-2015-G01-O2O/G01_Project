Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
	models : [ 
		'shopSearchModel',
		'locationModel',
		'statusModel'
	],
	stores : [ 
		'shopSearchStore',
		'locationStore',
		'statusStore'
	],
    views: [
        'searchView'
    ],
	controllers : [
		'searchController',
		'cmn.controller.cmnController'
	],
    name: 'shop',
	appFolder: '/TTO_Admin/js/shop',

    launch: function() {
        Ext.create('shop.view.searchView');
    }

});
