<#import "../utils.ftl" as u>

<!--

?? tells if the left hand operand's value is missing (means it's Java null or you have an undefined
variable there), and gives back false (missing) or true (not missing) accordingly.

?has_content is very much like ??, except it also returns false for an empty string or empty list
or empty map. (It doesn't return false for a 0, boolean false, etc.)

! is used to give a default value when a value is missing, like color!"no color". If you omit the
right hand operand of !, then the default value is an empty string and empty sequence and empty
hash on the same time.

?if_exists is the old way of writing ??. Don't use it.

-->

<@u.page title="IWTKM 3, sample 1, show&shout username form, results">
  <#if username?has_content>
    <h2>Now I know ur name: ${username}</h2>
  <#else>
    <h2>Coward, you did not write ur name!</h2>
  </#if>
</@u.page>
