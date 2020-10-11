<#import "../utils.ftl" as u>
<#import "/spring.ftl" as spring/>

<#-- This comment prevents compiler from warnings of unknown var -->
<#-- @ftlvariable name="awesomeHuman" type="iwtkm.season1.iwtkm03.model.AwesomeHuman" -->

<@u.page title="IWTKM 3, sample 2, awesome human registration form">

<#-- All values here are retrieved by appropriate get methods -->

  <h2>You're confirmed as an awesome human:</h2>

  <ul>
    <li>
      <b>You: </b>
      <#if awesomeHuman.firstName?has_content>${awesomeHuman.firstName},
      <#else>o_O without name, </#if>
      <#if awesomeHuman.lastName?has_content>${awesomeHuman.lastName}
      <#else>O_o without last name</#if>
    </li>
    <li>
      <b>With primary skill: </b>
      <#if awesomeHuman.primarySkill?has_content>${awesomeHuman.primarySkill}
      <#else>not achieved yet</#if>
    </li>
    <li>
      <b>With awesomeness level: </b>
      <#if awesomeHuman.awesomenessLevel?has_content>${awesomeHuman.awesomenessLevel}
      <#else>just awesome stranger</#if>
    </li>
    <li>
      <b>With kewlness: </b>
      <#if awesomeHuman.kewlnessItems?has_content>
        <ul>
          <#list awesomeHuman.kewlnessItems as kewlnessItem>
            <li>${kewlnessItem.displayName}</li>
          </#list>
        </ul>
      <#else>just kewl stranger
      </#if>
    </li>
    <li>
      <b>With ${awesomeHuman.amazingnessPoints} amazingness points! </b>
    </li>
    <li>
      <b>With incredible code: </b>${awesomeHuman.incrediblenessCode}
    </li>
  </ul>

</@u.page>
