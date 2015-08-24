Ext.Loader.setConfig({
    enabled: true
});

Ext.application({
    views: [
        'reviewView'
    ],
	controllers : [
		'reviewController',
		'cmn.controller.cmnController'
	],
    name: 'shop',
	appFolder: '/TTO_Admin/js/shop',

    launch: function() {
        Ext.create('shop.view.reviewView');
    }

});
