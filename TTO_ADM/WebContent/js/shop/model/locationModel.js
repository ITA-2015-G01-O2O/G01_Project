Ext.define('shop.model.locationModel', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    fields: [
        {
        	name: 'locationName',
        	convert: function(value, record) {
                var area  = record.get('area');
                var city  = record.get('city');
                var place  = record.get('place');

                return area+","+city+","+place;
            }
        },
        {
            name: 'locationId'
        },
        {
            name: 'area'
        },
        {
            name: 'city'
        },
        {
            name: 'place'
        }
    ]
});