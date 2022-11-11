<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${result == 1 }">
	<script>
		alert("글 삭제 성공");
		location.href="./P_ListAction.p?page="+${page};
	</script>
</c:if>