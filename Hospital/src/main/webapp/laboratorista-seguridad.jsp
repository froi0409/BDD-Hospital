<%@page import="entidades.Laboratorista"%>
<%
    if (request.getSession().getAttribute("codigo") == null || !request.getSession().getAttribute("tipoSesion").equals(Laboratorista.NOMBRE_TABLA)) {
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>