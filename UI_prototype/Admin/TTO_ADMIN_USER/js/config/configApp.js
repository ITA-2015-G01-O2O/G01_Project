Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
    views: [
        'searchView'
    ],
	controllers : [
		'cmn.controller.cmnController'
	],
    name: 'config',
	appFolder: 'js/config',

    launch: function() {
        Ext.create('config.view.searchView');
    }

});
