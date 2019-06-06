/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estagio.plataforma.api;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("v1")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.estagio.plataforma.api.ServiceAluno.class);
        resources.add(br.com.estagio.plataforma.api.ServiceCandidatos.class);
        resources.add(br.com.estagio.plataforma.api.ServiceCurso.class);
        resources.add(br.com.estagio.plataforma.api.ServiceDivulgacaoVaga.class);
        resources.add(br.com.estagio.plataforma.api.ServiceEmpresa.class);
        resources.add(br.com.estagio.plataforma.api.ServiceFaculdade.class);
        resources.add(br.com.estagio.plataforma.api.ServiceUsuario.class);
        resources.add(br.com.estagio.plataforma.api.ServiceVaga.class);
    }
    
}
