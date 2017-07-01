/**
 * 
 */
 
 function getdata(a)
 {
	 if(a=="2"){//公告
	 var textId=document.getElementById('textId');
	 var content=document.getElementById('content');
	 var itemtextId=document.getElementById('itemtextId');
	 var itemconten=document.getElementById('itemcontent');
	 itemtextId.value=textId.value;
	 itemcontent.value=content.value;
	 }
	 else if(a=="3")//供应商
		 {
		 var supplierId=document.getElementById('supplierId');
		 var supplierName=document.getElementById('supplierName');
		 var supplierAddress=document.getElementById('supplierAddress');
		 var suTel=document.getElementById('suTel');
		 var suFruit=document.getElementById('suFruit');
		 
		 var itemsupplierId=document.getElementById('itemsupplierId');
		 var itemsupplierName=document.getElementById('itemsupplierName');
		 var itemsupplieAddress=document.getElementById('itemsupplierAdress');
		 var itemsuTel=document.getElementById('itemsuTel');
		 var itemsuFruit=document.getElementById('itemsuFruit');
		 
		 itemsupplierId.value=supplierId.value;
		 itemsupplierName.value=supplierName.value;
		 itemsupplierAddress.value=supplierAddress.value;
		 itemsuTel.value=suTel.value;
		 itemsuFruit.value=suFruit.value;
		 
		 }
	 else {//商品
		 var goodsId=document.getElementById('goodsId');
		 var goodsName=document.getElementById('goodsName');
		 var typeId=document.getElementById('typeId');
		 var goodsDescription=document.getElementById('goodsDescription');
		 var supplierId=document.getElementById('supplierId');
		 var goodsPrice=document.getElementById('goodsPrice');
		 var itemgoodsId=document.getElementById('itemgoodsId');
		 var itemgoodsName=document.getElementById('itemgoodsName');
		 var itemtypeId=document.getElementById('itemtypeId');
		 var itemgoodsDescription=document.getElementById('itemgoodsDescription');
		 var itemsupplierId=document.getElementById('itemsupplierId');
		 var itemgoodsPrice=document.getElementById('itemgoodsPrice');
		  itemgoodsId.value=goodsId.value;
		  itemgoodsName.value=goodsName.value;
		  itemtypeId.value=typeId.value;
		  itemgoodsDescription.value=goodsDescription.value;
		  itemsupplierId.value=supplierId.value;
		  itemgoodsPrice.value=goodsPrice.value;
	 }
	
 }
 function setdata(a){
	 if(a=="2"){//公告
	     var textId=document.getElementById('textId');
		 var content=document.getElementById('content');
		 var itemtextId=document.getElementById('itemtextId');
		 var itemcontent=document.getElementById('itemcontent');
		 var img=document.getElementById('img');
		 var image2=document.getElementById('image2');	
	    img.value=image2.value;
		var temp=image2.value;
		img.setAttribute('data-image',temp);
		textId.value=itemtextId.value;
		content.value=itemcontent.value;
		}
	 else if(a=="3")//供应商
		 {
		 var supplierId=document.getElementById('supplierId');
		 var supplierName=document.getElementById('supplierName');
		 var supplierAddress=document.getElementById('supplierAddress');
		 var suTel=document.getElementById('suTel');
		 var suFruit=document.getElementById('suFruit');
		 
		 var itemsupplierId=document.getElementById('itemsupplierId');
		 var itemsupplierName=document.getElementById('itemsupplierName');
		 var itemsupplieAddress=document.getElementById('itemsupplierAdress');
		 var itemsuTel=document.getElementById('itemsuTel');
		 var itemsuFruit=document.getElementById('itemsuFruit');	 
		 var suImg=document.getElementById('suImg');
		 var image2=document.getElementById('image2');
		 suImg.value=image2.value;
		 var temp=image2.value;
		 suImg.setAttribute('data-image',temp);
		
		
		 supplierId.value=itemsupplierId.value;
		 supplierName.value=itemsupplierName.value;
		 supplierAddress.value=itemsupplierAddress.value;
		 suTel.value=itemsuTel.value;
		 suFruit.value=itemsuFruit.value;
		 
		 }
	 else{//商品
		 
		 var goodsId=document.getElementById('goodsId');
		 var goodsName=document.getElementById('goodsName');
		 var typeId=document.getElementById('TypeId');
		 var goodsDescription=document.getElementById('goodsDescription');
		 var supplierId=document.getElementById('supplierId');
		 var goodsPrice=document.getElementById('goodsPrice');
		 var itemgoodsId=document.getElementById('itemgoodsId');
		 var itemgoodsName=document.getElementById('itemgoodsName');
		 var itemtypeId=document.getElementById('itemtypeId');
		 var itemgoodsDescription=document.getElementById('itemgoodsDescription');
		 var itemsupplierId=document.getElementById('itemsupplierId');
		 var itemgoodsPrice=document.getElementById('itemgoodsPrice');
		 var img=document.getElementById('img');
		 var image2=document.getElementById('image2');
		 img.value=image2.value;
		 var temp=image2.value;
		 img.setAttribute('data-image',temp);
			goodsId.value=itemgoodsId.value;
			goodsName.value=itemgoodsName.value;
			typeId.value=itemtypeId.value;
			goodsDescription.value= itemgoodsDescription.value;
			supplierId.value=itemsupplierId.value;
			goodsPrice.value=itemgoodsPrice.value;
	 }
 }