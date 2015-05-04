
<font color="green"><h2> Please choose the roots you want included in the quiz.</h2></font>
<!--<g:each in="${words}">
    <p>Title: ${it}</p>
  
</g:each>
-->
<g:form action="chooseRoots" >
<g:radioGroup values='["1-प्रथमा", "2-द्वितिया", "3-तृतीया", "4-चतुर्थ", "5-पञ्चमी", "6-षष्टि", "7-सप्तमी", "8-अस्टमी", "all"]' labels='["1-प्रथमा", "2-द्वितिया", "3-तृतीया", "4-चतुर्थ", "5-पञ्चमी", "6-षष्टि", "7-सप्तमी", "8-अस्टमी" , " all"]' name="vibhakti" value = "all">
<p>
 ${it.radio }${it.label }
</g:radioGroup>

   <table>
      <tbody>
         <g:each in="${words}" status="i" var="rootInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                 <td>
                   <g:checkBox name="chose" value="${rootInstance}" checked="false" />
               
               </td>
               <td> ${rootInstance}</td>
           </tr>
        </g:each>
         <tr> <td><g:checkBox name="chose" value="all" checked="true" /> </td><td>all</td> </tr>
     </tbody>
   </table>
   <g:hiddenField name="correctAnswers" value="${correctAnswers}" />
<g:hiddenField name="totalQuestions" value="${totalQuestions}" />
   <g:submitButton name="chooseRoots" value="Choose" />
</g:form>