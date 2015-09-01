<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<my:admin tab="user">
<jsp:attribute name="nav">
		<my:user-nav tab="role"></my:user-nav>
	</jsp:attribute>
	<jsp:body>
		<form action="../" role="form" class="form-horizontal" method="post">
           <div class="form-group">
               <label for="name" class="col-sm-2 control-label">角色名:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="name" placeholder="please input name">
               </div>
           </div>
           <div class="form-group">
               <label for="code" class="col-sm-2 control-label">角色代码:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="code" placeholder="please input code">
               </div>
           </div>
           <div class="form-group">
               <label for="description" class="col-sm-2 control-label">描述:</label>
               <div class="col-sm-10">
                   <input class="form-control" name="description" placeholder="please input description">
               </div>
           </div>
          
           <div class="form-group">
               <label for="type" class="col-sm-2 control-label">拥有菜单:</label>
               <div class="col-sm-10">
                   <c:forEach items="${menus }" var="menu">
                   <div class="col-sm-10">
	                  <input name="menuIds" type="checkbox" value="${menu.id }"/>
	                   	${menu.name }(${menu.url})
                   </div>
                   </c:forEach>
               </div>
           </div>
           <div class="form-group">
			   <div class="col-sm-offset-2 col-sm-10">
			      <button type="submit" class="btn btn-default">保存</button>
			   </div>
			</div>
       </form>
	</jsp:body>
</my:admin>