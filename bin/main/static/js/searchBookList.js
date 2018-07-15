var searchTableCtrl = new Vue({
	el: '#listWrap',
	data : {
		noData : true,
		isData : false,
		query : '',
		target : 'all',
		category : '',
		sort : 'accuaracy',
		searchList : '',
		totalCount : 0,
		pageNo : 1,
		totalPageCount : 0,
		pageLimit : 10,
		endPage : 0,
		pageArray : '',
		startPage : 1,
		endPage : 10,
		showModal: false
	},
	
	created : function(){
	},
	methods : {
		searchBookList : function(data){
			if(this.query == ''){
				alert("검색어를 입력해 주세요.");
				return;
			}
			var param = {
					query : this.query,
					target : this.target,
					category : this.category,
					sort : this.sort,
					page : data
			}
			this.pageNo = data;
			param = JSON.stringify(param);	
			$.ajax({
				url : '/searchBookList.ajax',
				type : "POST",
				data : param,
				dataType : "json",
				contentType : "application/json",
				success : function (data) { 
					searchTableCtrl.succVocSearch(data);
				},
				fail : function(data){
					alert("Fail");
				}
			});
		},
		
		succVocSearch : function(data){
			this.searchList = data.documents;
			if(parseInt(data.meta.total_count) < 500){
				this.totalCount = data.meta.total_count;
			}else{
				this.totalCount = 500;
			}
			this.listNoData();
			this.totalPageCount = Math.ceil(this.totalCount/this.pageLimit);
			if(this.totalPageCount < parseInt(this.pageLimit)+1){
				this.endPage = this.totalPageCount;
				this.pageArray = this.range(this.startPage, this.endPage);
			}else{
				if(this.pageNo > this.endPage){
					if(this.pageNo%this.pageLimit != 0){
						this.startPage = (parseInt((this.pageNo) / parseInt(this.pageLimit)) * parseInt(this.pageLimit)) + 1;
					}else{
						this.startPage = (parseInt((this.pageNo) / parseInt(this.pageLimit)) -1) * parseInt(this.pageLimit);
					}
					if(this.totalPageCount > (parseInt(this.pageNo) + (parseInt(this.pageLimit) -1))){
						this.endPage = parseInt(this.pageNo) + (parseInt(this.pageLimit) -1);
					}else{
						this.endPage = this.totalPageCount;
					}
					
					this.pageArray = this.range(this.startPage, this.endPage);
				}else if(this.pageNo == this.endPage){
					this.pageArray = this.range(this.startPage, this.endPage);
				}else{
					if(this.pageNo < this.startPage){
						if((((this.pageNo) / parseInt(this.pageLimit)) -1) == 0 || this.pageNo == 1){
							this.startPage = 1;
						}else{
							this.startPage = (parseInt((this.pageNo) / parseInt(this.pageLimit)) -1) * parseInt(this.pageLimit);
						}
						this.endPage = parseInt(this.startPage) + (parseInt(this.pageLimit) -1);
					}else if(this.pageNo == this.startPage){
					}else{
						this.endPage = parseInt(this.startPage) + (parseInt(this.pageLimit) -1);
					}
					this.pageArray = this.range(this.startPage, this.endPage);
				}
			}
			
			this.listNoData();
		},
		range: function(min,max){
			var array = [],
			j = 0;
			for(var i = min; i <= max; i++){
				array[j] = i;
				j++;
			}
			return array;
		},
		listNoData : function(){
			if(this.totalCount == 0){
				this.noData = true;
				this.isData = false;
			}
			if(this.totalCount != 0){
				this.noData = false;
				this.isData = true;
			}
		},
		
		toBookDetailPage : function(data){
		    var frmPop= document.frmPopup;
		    var url = "/bookDetailInfo";
		    window.open('','bookDetailInfo', "width=1350, height=860");  
		    
		    frmPop.action = url;
		    frmPop.target = 'bookDetailInfo';
		    
		    frmPop.title.value = data.title;
		    frmPop.contents.value = data.contents;
		    frmPop.isbn.value = data.isbn;
		    frmPop.authors.value = data.authors;
		    frmPop.publisher.value = data.publisher;
		    frmPop.sale_price.value = data.sale_price;
		    frmPop.translators.value = data.translators;
		    frmPop.thumbnail.value = data.thumbnail;
		    frmPop.sale_yn.value = data.sale_yn;
		    frmPop.status.value = data.status;
		    frmPop.category.value = data.category;
		    frmPop.url.value = data.url;
		    frmPop.datetime.value = data.datetime.substring( 0, 10 );
		    frmPop.status.value = data.status;
		    
		    frmPop.submit();   
		}
	},
	mounted: function() {
		
	}
})
