<#import "../utils.ftl" as u>
<#import "/spring.ftl" as spring/>

<#-- See here https://docs.spring.io/autorepo/docs/spring/5.0.x/spring-framework-reference/web.html#mvc-view-freemarker-->

<@u.page title="IWTKM 3, sample 2, awesome human registration form">

  <h2>What's ur name, awesome human?</h2>
  <form action="/samples/registerAwesomeHuman" method="POST">
    <@spring.bind "awesomeHuman" />

    <@spring.formInput "awesomeHuman.firstName", "placeholder='Ur awesome name'"/>
    <@spring.formInput "awesomeHuman.lastName", "placeholder='Ur awesome last name *'"/>
    <@spring.showErrors ", ", "error"/><br/>

    <b>You skilled at: </b>
    <@spring.formSingleSelect "awesomeHuman.primarySkill", skillsOptions, ""/><br/>

    <b>U'r this awesome: </b>
    <@spring.formRadioButtons "awesomeHuman.awesomenessLevel", awesomenessLevels, ""/><br/>

    <b>U'r that kewl: </b>
    <@spring.formCheckboxes "awesomeHuman.kewlnessItems", kewlnessItems, ""/><br/>

    <@spring.formInput "awesomeHuman.amazingnessPoints", "placeholder='100'"/>
    <@spring.showErrors ", ", "error"/><br/>

    <@spring.formInput "awesomeHuman.incrediblenessCode" "placeholder='ur incredibleness code'"/>
    <@spring.showErrors ", ", "error"/><br/>

    <input type="submit" value="Know me!"/>
  </form>

</@u.page>
