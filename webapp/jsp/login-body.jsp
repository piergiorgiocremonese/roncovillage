<%@taglib prefix="s" uri="/struts-tags" %>      
       
       <script>
       function goback(){
           	alert('torna indietro');
           }
       function go(){
          	alert('vai avanti');
          }
      
       var parameters= new Array();
       var currentKey='';
       var ind = 0;
       </script>
      <div id="blockcnt">       
            
                <h2>Login</h2>
                
                <div class="main_column_section_content">
                	<p><s:property value="message"/></p>
                	<div> 
                    <s:form action="mylogin" method="POST" >
                    <input type="hidden" name="op" value="login" />
                    	<s:textfield name="username" label="Username" value=""/>
                    	<s:password name="password" label="Password" value="" />
                    	
                    	<tr>
            				<td><input type="button" value="back" onclick="goback" /></td>
            				<td><input type="submit" value="login" onclick="go" /></td>
            			</tr> 
            			</s:form>       
                	</div>
                </div>
              <div class="cleaner"></div>
              <div class="bottom"></div>
      </div>
            
      <div class="main_column_section">       
            <div class="bottom"></div>
 	  </div>
        
        	
        
