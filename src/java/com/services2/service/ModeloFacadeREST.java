/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services2.service;

import com.model.Modelo;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Bianca_Valentina
 */
@Stateless
@Path("com.model.modelo")
public class ModeloFacadeREST extends AbstractFacade<Modelo> {

    @PersistenceContext(unitName = "vehiculosPU")
    private EntityManager em;

    public ModeloFacadeREST() {
        super(Modelo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Modelo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Modelo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Modelo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modelo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Modelo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    //metodo llenar tabla moelo
    
     public Modelo login_modelo(String marca , String color,Date fecha_registro) {
       TypedQuery<Modelo> qry;
       qry = getEntityManager().createQuery( "SELECT m FROM Modelo m WHERE m.marca = :marca AND m.color = :color AND m.fechaRegistro = :fechaRegistro ", Modelo.class);
        qry.setParameter("marca", marca);
       qry.setParameter("color", color);
      qry.setParameter("fecha_registro", fecha_registro);
      try {
            return qry.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }

    }
    //postamn crear
     //verficar los nombres de los parametros
    
    @POST
    @Path("crear2")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear2(@FormParam("marca") String marca, @FormParam("color") String color,@FormParam("fechaRegistro") Date fechaRegistro) {
    
    String mensaje="{\"exitoso\":false}";
    create (new Modelo(marca,color, fechaRegistro));
      try {
           create (new Modelo(marca, color,fechaRegistro));
           mensaje="{\"exitoso\":false}";
       } catch (Exception e) {
       }
    return mensaje;
    
    }
    
}
