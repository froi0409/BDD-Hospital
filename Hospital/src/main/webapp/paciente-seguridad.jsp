<%@page import="entidades.Paciente"%>
<%
    if (request.getSession().getAttribute("codigo") == null || !request.getSession().getAttribute("tipoSesion").equals(Paciente.NOMBRE_TABLA)) {
        request.getSession().invalidate();
        response.sendRedirect("inicio-sesion.jsp");
    }
%>