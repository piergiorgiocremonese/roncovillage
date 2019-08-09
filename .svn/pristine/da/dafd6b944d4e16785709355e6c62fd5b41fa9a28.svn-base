<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">
var currFoto=0;
var auto = function next(){
	if (currFoto<listafoto.length){
		currFoto++;
		}else{
		currFoto=0;
		}
		document.getElementById('foto').src = listafoto[currFoto];
} 
function previous(){
	if (currFoto>0){
		currFoto=currFoto-1;
		}else{
		currFoto=listaFoto.length-1;
		}
		document.getElementById('foto').src = listafoto[currFoto];
}

var listafoto = new Array();
<s:iterator var="f" value="files" status="i">
listafoto[<s:property value="#i.count"/>]= '<s:property value="#f"/>';
</s:iterator>
</script>
<div id="mainblock" >

<div id="maincolumn" style="position:absolute;top:50px;left:150px"><img id="foto" src="<s:property value="foto"/>"/></div>

<script>
setInterval(auto,5000);
</script>
</div>
