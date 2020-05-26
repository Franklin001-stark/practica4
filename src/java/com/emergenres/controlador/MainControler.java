
package com.emergenres.controlador;

import com.emergentes.modelo.blog;
import com.emergentes.utiles.ConexionBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MainControler", urlPatterns = {"/MainControler"})
public class MainControler extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String op;
        op = (request.getParameter("op") != null) ? request.getParameter("op") : "list";
        ArrayList<blog> lista = new ArrayList<blog>();
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;

        if (op.equals("list")) {
            try {
                String sql = "SELECT * FROM comentarios";
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    blog lib = new blog();
                    lib.setId(rs.getInt("id"));
                    lib.setId_entrada(rs.getInt("id_entrada"));
                    lib.setFecha(rs.getString("fecha"));
                    lib.setTitulo(rs.getString("titulo"));
                    lib.setComentario(rs.getString("comentario"));
                    lista.add(lib);
                }
                request.setAttribute("lista", lista);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (SQLException ex) {
                System.out.println("errosr en sql" + ex.getMessage());
            } finally {
                canal.desconectar();
            }
        }
        
        if (op.equals("nuevo")) {
            blog l = new blog();
            request.setAttribute("libro", l);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
if( op.equals("editar")){
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                
                String sql = "select * from comentarios where id=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                
                rs = ps.executeQuery();
                blog li = new blog();
                while(rs.next()){
                 
                    li.setId(rs.getInt("id"));
                    li.setId_entrada(rs.getInt("id_entrada"));
                    li.setFecha(rs.getString("fecha"));
                    li.setTitulo(rs.getString("titulo"));
                    li.setComentario(rs.getString("comentario"));
                    
                }
                request.setAttribute("libro", li);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
            } catch (SQLException ex) {
               System.out.println("error de sql :" + ex.getMessage());

            }
}
        if (op.equals("eliminar")) {
            try {
                int id = Integer.parseInt(request.getParameter("id"));

                String sql = "delete from comentarios where id=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("error de sql :" + ex.getMessage());

            } finally {
                canal.desconectar();
            }
            response.sendRedirect("MainControler");
        }

        
    }


   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int id_entrada = Integer.parseInt((request.getParameter("id_entrada")));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        String  comentario = request.getParameter("comentario");

        blog l = new blog();
        l.setId(id);
        l.setId_entrada(id_entrada);
        l.setFecha(fecha);
        l.setTitulo(titulo);
        l.setComentario(comentario);
        
        ConexionBD canal = new ConexionBD();
        Connection conn = canal.conectar();
        PreparedStatement ps;
        ResultSet rs;
        if (id == 0) {

            String sql = "insert into comentarios (id_entrada , fecha, titulo, comentario) values (?,?,?,?)";
            try {
                ps = conn.prepareStatement(sql);
                ps.setInt(1, l.getId_entrada());
               ps.setString(2, l.getFecha());
                ps.setString(3, l.getTitulo());
                ps.setString(4, l.getComentario());
                
                ps.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("error en sql: " + ex.getMessage());
            } finally {
                canal.desconectar();
            }
            response.sendRedirect("MainControler");
        }
//si el registro ya existe
        else{
            try {
                String sql = "update comentarios set id_entrada=?, fecha=?, titulo=?,comentario = ? where id =?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, l.getId_entrada());
                ps.setString(2, l.getFecha());
                ps.setString(3, l.getTitulo());
                ps.setString(4, l.getComentario());
                ps.setInt(5, l.getId());
                ps.executeUpdate();
            } catch (SQLException ex) {
                 System.out.println("error al actualizar :" + ex.getMessage());
 }
            response.sendRedirect("MainControler");
        }
    }

    
}
