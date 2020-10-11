<#macro page title="IWTKM 3">
  <html>
  <head>
    <title><#if title??>${title}<#else>IWTKM 3</#if></title>
    <style>
      .error {color:red}
    </style>
  </head>
  <body>

  <img src="/resources/images/spring-logo.png"/>
  <h1>IWTKM 3, Udemy course for Spring + Hibernate</h1>

  <#-- This processes the enclosed content -->
  <#nested/>

  </body>
  </html>
</#macro>
