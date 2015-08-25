Ext.define('config.controller.searchController', {
	extend : 'Ext.app.Controller',
	basicConfigDTO:{},

	init : function(application) {
		this.control({
			'#searchView':{
				afterrender:this.loadData
			},
			'#categoryList' : {
				selectionchange : this.checkButtonAccess
			},
			'#saveConfigBtn':{
				click:this.saveConfig
			},
			'#addBtn':{
				click:this.addCategory
			},
			'#deleteBtn':{
				click:this.deleteCategory
			},
			"#searchView textfield":{
				blur: this.toTrimValue
			},
			'#refreshConfigBtn':{
				click:this.loadData
			}
		});
	},
	toTrimValue:function(comp){
		if(Ext.typeOf(comp.getValue())=='string'){
			comp.setValue(Ext.String.trim(comp.getValue()));
		}
	},
	loadData:function(){
		var me=this;
		Ext.Ajax.request({
			url : 'load.do',
			success : function(response) {
				var responseData = Ext.decode(response.responseText);
				me.basicConfigDTO=responseData;
				Ext.getBody().unmask();
				Ext.getCmp('serviceHotLine').setValue(me.basicConfigDTO.hotLine);
				Ext.getCmp('orderAutoConfirmFiled').setValue(me.basicConfigDTO.orderAutoConfirmTime);
				Ext.getCmp('orderAutoCancelFiled').setValue(me.basicConfigDTO.orderAutoCancelTime);
				
				var temp=[];
				Ext.each(me.basicConfigDTO.categorys,function(value,index){
					if(!Ext.isEmpty(value.configValue)){
						var categoryModel= Ext.create('config.model.configModel');
						categoryModel.data.configValue=value.configValue;
						categoryModel.data.configId=value.configId;
						temp.push(categoryModel);
					}
				});
				
				var grid = Ext.getCmp('categoryList');
				var store=grid.getStore();
				store.loadData(temp);
			},
			failure : function() {
				Ext.getBody().unmask();
			}
		});
	},
	checkButtonAccess:function(){
		var grid = Ext.getCmp('categoryList');
		var selectedRows = grid.getSelectionModel().getSelection();
		if(selectedRows.length==1 && Ext.isEmpty(selectedRows[0].data.configId)){
			Ext.getCmp('deleteBtn').setDisabled(false);
		}else{
			Ext.getCmp('deleteBtn').setDisabled(true);
		}
	},
	saveConfig:function(){
		var serviceHotLine=Ext.getCmp('serviceHotLine').getValue();
		var orderAutoConfirm=Ext.getCmp('orderAutoConfirmFiled').getValue();
		var orderAutoCancel=Ext.getCmp('orderAutoCancelFiled').getValue();
		var store=Ext.getCmp('categoryList').getStore();
		
		var me=this;
		if(!Ext.isEmpty(serviceHotLine) && !Ext.isEmpty(orderAutoConfirm) && !Ext.isEmpty(orderAutoCancel)){
			me.basicConfigDTO.hotLine=serviceHotLine;
			me.basicConfigDTO.orderAutoConfirmTime=orderAutoConfirm;
			me.basicConfigDTO.orderAutoCancelTime=orderAutoCancel;
			var categoryData=[];
			store.each(function(){
				categoryData.push({configId:this.data.configId,configValue:this.data.configValue});
			});
			me.basicConfigDTO.categorys=categoryData;
			
			Ext.Ajax.request({
				url : 'save.do',
				params : {
					hotLine : me.basicConfigDTO.hotLine,
					orderAutoConfirmTime : me.basicConfigDTO.orderAutoConfirmTime,
					orderAutoCancelTime : me.basicConfigDTO.orderAutoCancelTime,
					categorys: Ext.encode(me.basicConfigDTO.categorys)
				},
				success : function(response) {
					Ext.MessageBox.alert('Tip', 'Success');
					Ext.getBody().unmask();
					me.loadData();
				},
				failure : function() {
					Ext.MessageBox.alert('Tip', 'Error');
					Ext.getBody().unmask();
					me.loadData();
				}
			});
			
		}
	},
	addCategory:function(){
		var grid = Ext.getCmp('categoryList');
		var store=grid.getStore();
		
		store.insert(store.data.length,Ext.create('config.model.configModel'));
	},
	deleteCategory:function(){
		var grid = Ext.getCmp('categoryList');
		var selectedRows = grid.getSelectionModel().getSelection();
		var store=grid.getStore();
            
		if(selectedRows.length==1){
			Ext.MessageBox.confirm('Confirm', 'Are you sure?',function(btn, text){
				if (btn == 'yes'){
					if(Ext.isEmpty(selectedRows[0].data.configId)){
						store.remove(selectedRows[0]);	
					}
				}
			});
		}
	}
});