<%-- 
    Document   : recebealterausuariofisico
    Created on : 27/08/2021, 14:12:25
    Author     : Maria
--%>
<%@page import="java.sql.Date"%>
<%@page import="dominio.UsuarioFisico"%>
<%@page import="dominio.PessoaFisica"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  //instancia a pessoa física = PF
    PessoaFisica pf = new PessoaFisica();
    
    //instanciar o login da = PF
    UsuarioFisico login = new UsuarioFisico();
    
    String oldCpf = request.getParameter("cpf");
    
    pf.setNome(request.getParameter("nome"));
    pf.setSobrenome(request.getParameter("sobrenome"));
    pf.setDataNascimento(Date.valueOf(request.getParameter("nascimento")));
    pf.setEmail(request.getParameter("email"));
    pf.setCelular(request.getParameter("telefone"));
    pf.setCep(request.getParameter("cep"));
    pf.setEstado(request.getParameter("estado"));
    pf.setCidade(request.getParameter("cidade"));
    pf.setBairro(request.getParameter("bairro"));
    pf.setRua(request.getParameter("rua"));
    pf.setNumero(Integer.parseInt(request.getParameter("numero")));
    pf.setComplemento(request.getParameter("complemento"));

    login.setEmail(request.getParameter("email"));
    login.setSenha(request.getParameter("senha"));
    
    //se o email já está sendo utilizado no cadastro fisico ou juridico não faz cadastro
    if(pf.alterarDados(oldCpf) && login.alterarUsuario(oldCpf)) {
        request.getSession().setAttribute("resultado", "CadastroAlterado");
        response.sendRedirect("perfil.jsp");     
    }else{
        request.getSession().setAttribute("resultado", "CadastroNaoAlterado");
        response.sendRedirect("alterarusuariofisico.jsp");
    }
%>  