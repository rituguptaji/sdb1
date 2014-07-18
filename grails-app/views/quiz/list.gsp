
<font color="green"><h2> Please choose the roots you want included in the quiz.</h2></font>
<!--<g:each in="${words}">
    <p>Title: ${it}</p>
 
</g:each>
-->
<g:form action="chooseRoots" >
   <table>
      <tbody>
         <g:each in="${words}" status="i" var="rootInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                 <td>
                   <g:checkBox name="chose" value="${rootInstance}" checked="{false}" />
               
               </td>
               <td> ${rootInstance}</td>
           </tr>
        </g:each>
     </tbody>
   </table>
   <g:hiddenField name="correctAnswers" value="${correctAnswers}" />
<g:hiddenField name="totalQuestions" value="${totalQuestions}" />
   <g:submitButton name="chooseRoots" value="Choose" />
</g:form>