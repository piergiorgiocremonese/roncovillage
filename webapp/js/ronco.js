function updateInfoArray(k,a){
	var text='<ul style="color:red;font-size:x-large">';
	for (var i=0;i<a.length;i++){
		text = text + '<li>'+a[i]+'</li>';
	}
	text = text + '</ul>';
	document.getElementById(k).innerHTML=text;
}


function updateInfoItemList(info){
	var list = info.infoList;
	var text = '';
	for(var key in info) {
		if (Array.isArray(info[key])){
			text = text + '<ul>';
			var list = info[key];
			for (var i=0;i<list.length;i++){
				
				text = text + '<li>'+list[i].info+'<a href="'+list[i].href+'" target="_blank">';
				text = text + '<input type="button" value="Scarica-'+ list[i].tag+ '"/></a></li>';
				 
			}
			text = text + '</ul>';
			document.getElementById(key).innerHTML=text;
		}else{
			document.getElementById(key).innerHTML=info[key];
		}
	}
	
   	
}


function updateInfo(info){
	//var s = JSON.parse(info);
	for(var k in info) {
   		if (Array.isArray(info[k])){
   			//alert(k + ' is array');
   			updateInfoArray(k,info[k]);
   		}else{
   			//alert('aggiorno ' + k + ' con ' + info [k]);
   			document.getElementById(k).innerHTML=info[k];
   		}
   	}
}

function updateAttributes(info){
	for(var k in info) {
		//alert("aggiorno "+k);
   		for (var h in info[k]){
   			//alert("aggiornamento elemento "+k + "attributo "+h + " con " + info[k][h]);	
   			if ((h == 'disabled')&&(info[k][h] == false)){
   				document.getElementById(k).removeAttribute(h);
   				//alert('remove ' + h +' da ' +k);
   			}	
   			else{
   				document.getElementById(k).setAttribute(h,info[k][h]);
   				//alert("aggiornamento elemento "+k + "attributo "+h + " con " + info[k][h]);	
   			}
   		}	
   		
   	}
}

function refreshId(id){
	//alert ('cerco elemento  ' + id);
	var x = document.getElementById(id);
	if (x!=null){
		
		//alert('aggiorno ' +id + ' con ref=' + x);
		document.getElementById(id).innerHTML=x.innerHTML;
	}else{
		//alert('purtroppo ' + id + ' = ' +x);
	}
}

function test(){
	alert('vai dove ti pare');
}

function goBack() {
    window.history.back();
}


function cambia(id,stato){
	var x = document.getElementById(id);
	//alert(x.innerHTML);
	if (stato == 'ok'){
		var text = '<td>Fratello: </td><td><input type="text" name="fratellonome" value=""/></td>';
		x.innerHTML=text;
	}else{
		x.innerHTML='';
	}
	//alert('fine cambio');
}


			  function updBgImage(div,list){
                        //var myData = JSON.parse(info);
                       // alert("cerco elemento "+div);
                        var x = document.getElementById(div);
                        x.style.backgroundImage = "url('"+list.images[current].src+"')";
                        /*
                        x.style.background = "url('"+list.images[current].src+"')";
                        
                        var l = x.attributes;
                        for (var i=0;i<l.length;i++)
                        	alert("attr:"+l[i]);
                        //var e = x.style;
                       // e.setAttribute("background-image",list.images[current].src);
                       //e.setAttribute("style.back",list.images[current].src);
                       */
                        current++;
                        if (current>=list.images.length)
                                current=0;

                }



                function updImage(list){
                        //var myData = JSON.parse(info);
                        var e = document.getElementById('albumfoto');
                        e.setAttribute("src",list.images[current].src);
                        current++;
                        if (current>=list.images.length)
                                current=0;

                }


