<%@taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">
var currFoto=1;
function next(){
	if (currFoto<listafoto.length){
		currFoto++;
		document.getElementById('foto').src = listafoto[currFoto];
		}else{
		alert('fine');
			}
} 
function previous(){
	if (currFoto>0){
		currFoto=currFoto-1;
		document.getElementById('foto').src = listafoto[currFoto];
		}else{
		alert('inizio');
			}
}

var listafoto = new Array();
<s:iterator var="f" value="fotoList" status="i">
listafoto[<s:property value="#i.count"/>]= 'showImage?file=<s:property value="file"/>';
</s:iterator>
</script>
<div id="mainblock" style="position:absolute;top:10px" >
<div id="colonnasinistra"><div id="innerleft" style="position:absolute;top:50px;left:10px"><a href="javascript:previous()"><img src="images/sinistra.png" style="position:relative;top:350px;left:0px" /></a></div></div>
<div id="maincolumn" style="position:absolute;top:50px;left:150px"><img id="foto" src="showImage?file=<s:property value="picture.file" />" style="position:absolute;margin:0 auto;top:0;left:0;right:0;bottom:0"/></div>
<div id="colonnadestra" style="position:relative"><div id="innerright" style="position:relative;top:50px;left:1150px"><a href="javascript:next()"><img src="images/destra.png" style="position:relative;top:350px;left:10px" /></a></div></div>
</div>