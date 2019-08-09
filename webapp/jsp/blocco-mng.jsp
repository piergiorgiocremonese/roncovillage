<%@taglib prefix="s" uri="/struts-tags" %>


<s:form action="updBlock"  enctype="multipart/form-data" method="POST" onsubmit="return fill();" >
<s:textfield name="bloccoId" label="Nome" value="%{blocco.bloccoId}"/>
<s:textfield name="tipo" label="Tipo" value="%{blocco.tipo}"/>
<s:textfield name="ordine" label="Ordine" value="%{ordine}"/>
<tr><td>Info</td><td><textarea name="allsan" rows="5" cols=40/><s:property value="blocco.info" /></textarea></td></tr>
<tr><td colspan="2"><inut type="submit" name="save" value="Save" /></td></tr>

</s:form>


