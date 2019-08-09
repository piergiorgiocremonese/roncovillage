<%@taglib prefix="s" uri="/struts-tags" %>


<p><center>Lista Azioni Archivio</center></p>
<center>
<table>
<tr><td colspan="2">GENERALE <s:property value="#g"/></td></tr>
	<tr>
	<td>Ragazzi registrati</td><td><a href="ragazziRegistrati">Guarda</a></td>
	</tr>


<s:iterator var="g" value="periodi" status="stat">
<tr><td colspan="2">ANNO <s:property value="key"/></td></tr>
	<tr>
	<td colspan="2"><img src="<s:property value="icona"/>"></td>
	</tr>
	<tr>
	<td>Quadro Settimane</td><td><a href="periodi?anno=<s:property value="key"/>">Guarda</a></td>
	</tr>
	
	<tr>
	<td>Registro Pagamenti</td><td><a href="showRegistro?anno=<s:property value="key"/>">Guarda</a></td>
	</tr>
	<tr>
	<td>Quadro Pagamenti</td><td><a href="getQuadro?anno=<s:property value="key"/>">Guarda</a></td>
	</tr>
	</tr>
	<tr>
	<td>Ragazzi iscritti</td><td><a href="ragazziAnno?anno=<s:property value="key"/>">Guarda</a></td>
	</tr>
	<tr><td>&nbsp;</td>
		<td>
		<table>
			
  				<s:iterator var="p" value="value">
    				<tr><td>Periodo: <s:property value="#p.ordine"/> </td><td><a href="search?settimana=<s:property value="#p.oid" />&anno=<s:property value="key"/>" >Guarda presenze</a></td></tr>
  				</s:iterator>
  		</table>
		</td>
	</tr>
	<tr>
	<td>Gallery</td>
	<td>
	<a href="listaGruppi?op=view&anno=<s:property value="key"/>" >Guarda</a>
	</td>
	</tr>	
	<tr>
	<td>Gallery Management</td>
	<td>
	<a href="listaGruppi?op=mng&anno=<s:property value="key"/>" >Guarda</a>
	</td>
	</tr>	
	<tr><td colspan="2">&nbsp;</td></tr>
	
	</s:iterator>

</table>

</center>