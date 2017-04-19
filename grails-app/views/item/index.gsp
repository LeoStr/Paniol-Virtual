<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'item.label', default: 'Item')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <asset:javascript src="fp.js"/>
        <asset:stylesheet src="fp.css"/>
    </head>
    <body>
        <a href="#list-item" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            <li id="logout"><a class="logout" href="${createLink(uri: '/logoff')}"><g:message code="default.logout.label" args="[entityName]" /></a></li>
            </ul>
        </div>
        <filterpane:filterButton text="Filtrar"  appliedText="Modificar Filtro"/>
        <filterpane:filterPane domain="Item" />
        <div id="list-item" class="content scaffold-list" role="main">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <f:table collection="${itemList}"  params="${filterParams}"/>

            <div class="pagination">
                <!-- <g:paginate total="${itemCount ?: 0}" params="${filterParams}" /> -->
                <filterpane:paginate total="${itemCount}" domainBean="paniolvirtual.Item"/>
            </div>
        </div>
    </body>
</html>