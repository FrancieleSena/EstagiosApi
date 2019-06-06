/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.plataforma.bo;

import br.com.estagio.plataforma.dao.DAOempresa;
import br.com.estagio.plataforma.fw.Data;
import br.com.estagio.plataforma.to.*;
import java.sql.Connection;
import java.util.List;


public class BOempresa {
    
    public static void inserir(TOempresa t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOempresa.inserir(c, t);
        }
    }

    public static void alterar(TOempresa t) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOempresa.alterar(c, t);
        }
    }

    public static void excluir(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            DAOempresa.excluir(c, id);
        }
    }

    public static TOempresa obter(int id) throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOempresa.obter(c, id);
        }
    }

    public static List<TOempresa> lista() throws Exception {
        try (Connection c = Data.openConnection()) {
            return DAOempresa.lista(c);
        }
    }    

}