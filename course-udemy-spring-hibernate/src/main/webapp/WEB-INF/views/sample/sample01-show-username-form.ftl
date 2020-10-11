<#import "../utils.ftl" as u>

<@u.page title="IWTKM 3, sample 1, show&shout username form">

  <h2>What's ur name?</h2>

  <form action="/samples/showUserName" method="GET">
    <input type="text" name="username" placeholder="Say it"/>
    <input type="submit"/>
  </form>

  <form action="/samples/shoutUserName" method="GET">
    <input type="text" name="username" placeholder="Shout it!"/>
    <input type="submit"/>
  </form>

  <form action="/samples/shoutLouderUserName" method="GET">
    <input type="text" name="username" placeholder="LOUDER!!"/>
    <input type="submit"/>
  </form>

</@u.page>
