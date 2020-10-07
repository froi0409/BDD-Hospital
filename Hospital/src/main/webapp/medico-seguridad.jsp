<%@page import="entidades.Medico"%>
<%
    if (request.getSession().getAttribute("codigo") == null || !request.getSession().getAttribute("tipoSesion").equals(Medico.NOMBRE_TABLA)) {
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>