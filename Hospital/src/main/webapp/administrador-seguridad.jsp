<%@page import="entidades.Administrador"%>
<%
    if (request.getSession().getAttribute("codigo") == null || !request.getSession().getAttribute("tipoSesion").equals(Administrador.NOMBRE_TABLA)) {
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>