function searchStore(){
    var storeName=$('#searchStoreName').val();
    var location=$().val();
     $.ajax({
		type : "post",
		url : "../comment/getallCommentByScore.do",
		cache : false,
		data : {
			merId : merId,
            score:score
		},
		error : function(error) {
			alert("error");
		}
	}).done(function(json) {
		if (json != "") {
			if (json.isSuccess == true) {
				addComment(json.data);
			} 
		}
	});
}