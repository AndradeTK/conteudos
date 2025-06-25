/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package view;

import controller.AnimalDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Animal;

/**
 *
 * @author Bryan
 */
@WebServlet(name = "Enviar", urlPatterns = {"/Enviar"})
public class Enviar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession sessao = request.getSession(true);
        ArrayList<Animal> animal = (ArrayList<Animal>) sessao.getAttribute("animal");
        if (animal == null) {
            animal = new ArrayList<>();
        }

        String acao = request.getParameter("b1");
        int codigo = Integer.parseInt(request.getParameter("inCodigo"));
        String nome = request.getParameter("inNome");
        float peso = Float.parseFloat(request.getParameter("inPeso"));

        Animal obj = new Animal();
        try {
            obj.setCodigo(codigo);
            obj.setNome(nome);
            obj.setPeso(peso);
        } catch (Exception e) {
            System.out.println("Erro ao alterar animal: " + e.getMessage());
        }

        switch (acao.trim().toLowerCase()) {
            case "incluir":
                try {
                    animal.add(obj);
                } catch (Exception e) {
                    System.out.println("Erro ao alterar animal: " + e.getMessage());
                }
                break;

            case "alterar":
                try {
                    for (int i = 0; i < animal.size(); i++) {
                        if (animal.get(i).getCodigo() == codigo) {
                            animal.get(i).setNome(nome);
                            animal.get(i).setPeso(peso);
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao alterar animal: " + e.getMessage());
                }
                break;

            case "deletar":
                try {
                    animal.removeIf(a -> a.getCodigo() == codigo);
                } catch (Exception e) {
                    System.out.println("Erro ao alterar animal: " + e.getMessage());
                }
                break;

            case "listar":
                // Só exibe, não faz alterações
                break;

            default:
                out.println("<h1>Ação desconhecida! " + acao + "</h1>");
        }

        sessao.setAttribute("animal", animal);

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>CRUD Sessão</title></head><body>");
        out.println("<h2>Lista de Animais:</h2>");
        for (Animal a : animal) {
            out.println("<p>Código: " + a.getCodigo() + " | Nome: " + a.getNome() + " | Peso: " + a.getPeso() + "</p>");
        }
        out.println("<br><a href='index.html'>Voltar</a>");
        out.println("</body></html>");
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
