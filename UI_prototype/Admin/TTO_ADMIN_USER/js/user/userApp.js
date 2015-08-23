Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
	models : [ 
		'userModel' 
	],
	stores : [ 
		'userStore'
	],
    views: [
        'searchView'
    ],
	controllers : [ 
		'searchController' ,
		'cmn.controller.cmnController'
	],
    name: 'user',
	appFolder: 'js/user',

    launch: function() {
        Ext.create('user.view.searchView');
    }

});
