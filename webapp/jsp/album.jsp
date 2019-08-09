<%@taglib prefix="s" uri="/struts-tags" %>

<s:set var="counter" value="0"/>
<s:set var="righe" value="0"/>
<s:set var="page" value="0"/>

<s:set var="dimRiga" value="%{dimensioneRiga}"/>
<s:set var="dimPage" value="%{dimensionePage}"/>

<script type="text/javascript">
var listafoto = new Array();
<s:iterator var="f" value="fotoList" status="i">
<s:set var="idx" value="%{#i.count-1}"/>
listafoto[<s:property value="#idx"/>]= new Array();
listafoto[<s:property value="#idx"/>][0]='<s:property value="file"/>';
listafoto[<s:property value="#idx"/>][1]='<s:property value="iconwidth"/>';
listafoto[<s:property value="#idx"/>][2]='<s:property value="iconheight"/>';

</s:iterator>

var dimRiga = <s:property value="dimensioneRiga"/>;
var dimPage = <s:property value="dimensionePage"/>;
var currPage = 1;


var currFoto=0;


function previousPage(){
		//alert('prev Page: current = '+currPage);
	if (currPage==1){
		alert('prima pagina');
	}else{
	currPage=currPage-1;
	var page = currPage-1;
	
	var start = dimRiga*dimPage*page;
	var end = start + (dimRiga*dimPage);
	
	if (end>listafoto.length)
		end=listafoto.length;
	var nc=0;
	var txt = '<tr><td><table><tr>';	
	for (var i=start;i<end;i++){
		if (nc>=dimRiga){
			nc=0;
			txt = txt + '</tr></table></td></tr><tr><td><table><tr>';	 
		}
		txt = txt +'<td>'; 
		txt = txt + '<a target="_blank" href="showImage?file='+listafoto[i][0]+'">';
		txt = txt + '<img src="showImage?file='+listafoto[i][0]+'" width="'+listafoto[i][1]+'" heigth="'+listafoto[i][2]+'" />';
		txt = txt + '</a>';
		txt = txt + '</td>';
		nc++;
		
	}
	txt = txt + '</tr>';	
	document.getElementById('album').innerHTML=txt;
	}
		
}


function nextPage(){
		//alert('next Page');
	
	var start = dimRiga*dimPage*currPage;
	if (start>listafoto.length){
		alert('ultima pagina');
	}else{
	var end = start + (dimRiga*dimPage);
	if (end>listafoto.length)
		end=listafoto.length;
	var nc=0;
	var txt = '<tr>';	
	for (var i=start;i<end;i++){
		if (nc>=dimRiga){
			nc=0;
			txt = txt + '</tr><tr>';	 
		}
		txt = txt + '<td>';
		txt = txt + '<a target="_blank" href="showImage?file='+listafoto[i][0]+'">';
		txt = txt +'<img src="showImage?file='+listafoto[i][0]+'" width="'+listafoto[i][1]+'" heigth="'+listafoto[i][2]+'" />';
		txt = txt + '</a>';
		txt = txt + '</td>';
		nc++;
		
	}
	txt = txt + '</tr>';	
	currPage++;
	document.getElementById('album').innerHTML=txt;
	}	
}


function next(){
	if (currFoto<listafoto.length){
		currFoto++;
		document.getElementById('foto').src = listafoto[currFoto][0];
		}else{
		alert('fine');
			}
} 
function previous(){
	if (currFoto>0){
		currFoto=currFoto-1;
		document.getElementById('foto').src = listafoto[currFoto][0];
		}else{
		alert('inizio');
			}
}

</script>


<div id="mainblock" style="position:absolute;top:10px" >
<div style="position:relative;top:25px;left:50px">

<a href="javascript:previousPage()"><img src="images/sinistra.png" style="position:absolute;left:100px;top:0px"/></a>
<div style="position:absolute;left:450px;top:0px">

<a href="showAlbum?tipo=single&oid=<s:property value="oid" />" >Scorri le foto singolarmente</a>

</div>

<!-- &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
<a href="javascript:nextPage()"><img src="images/destra.png" style="position:absolute;left:700px;top:0px"/></a>
</div>

</p>
<div style="position:absolute;left:100px;top:150px">
<table id="album">
<tr><td><table><tr>

<s:iterator var="f" value="fotoList" status="i">

<s:if test="%{#counter>=#dimRiga}">
</tr></table></td></tr>
<s:set var="counter" value="0"/>
<s:set var="righe" value="%{#righe+1}"/>

<tr><td><table><tr>
</s:if>
<s:if test="%{#righe<#dimPage}">
<td>
<a href="showImage?file=<s:property value="file"/>" target="_blank" ><img src="showImage?file=<s:property value="file"/>" width="<s:property value="iconwidth"/>" height="<s:property value="iconheight"/>"/></a>
</td>
<s:set var="counter" value="%{#counter+1}" />
</s:if>
<s:else>

</s:else>
</s:iterator>
</tr></table></td></tr>
</table>
<p>
<br/>
</p>

</div>
</div>

