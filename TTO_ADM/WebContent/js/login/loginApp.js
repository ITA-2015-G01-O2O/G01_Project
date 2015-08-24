Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
    views: [
        'loginView'
    ],
	controllers : [
		'loginController'
	],
    name: 'login',
	appFolder: '/TTO_Admin/js/login',

    launch: function() {
        Ext.create('login.view.loginView');
    }

});
