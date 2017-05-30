/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services.service;

import com.model.Vehiculo;
import static com.model.Vehiculo_.placa;
import static com.model.Vehiculo_.subtipo;
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
@Path("com.model.vehiculo")
public class VehiculoFacadeREST extends AbstractFacade<Vehiculo> {

    @PersistenceContext(unitName = "vehiculosPU")
    private EntityManager em;

    public VehiculoFacadeREST() {
        super(Vehiculo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Vehiculo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Vehiculo entity) {
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
    public Vehiculo find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vehiculo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
     //metodo login
     public Vehiculo login1(String subtipo, String placa) {
        TypedQuery<Vehiculo> qry;
        qry = getEntityManager().createQuery(    "SELECT v FROM Vehiculo v WHERE v.subtipo = :subtipo AND v.placa = :placa AND v.eliminado = :eliminado ", Vehiculo.class);
        qry.setParameter("subtipo", subtipo);
        qry.setParameter("placa", placa);
        qry.setParameter("eliminado", false);
        try {
            return qry.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }

    }
    //postamn crear
     //verficar los nombres de los parametros
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear1(@FormParam("subtipo") String subtipo, @FormParam("placa") String placa) {
    
    String mensaje="{\"exitoso\":false}";
    create (new Vehiculo(subtipo,placa, false));
      try {
           create (new Vehiculo(subtipo, placa, false));
           mensaje="{\"exitoso\":false}";
       } catch (Exception e) {
       }
    return mensaje;
    
    }
    
       //postr comparar usuarios
    @POST
    @Path("comparar2")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})    
    public String comparar2(@FormParam("subtipo") String subtipo, @FormParam("placa") String placa) {
    String menaje="{\"exitoso\":false}";
    
    String mensaje="{\"exitoso\":false}";
    
       try {
           if (crear1(subtipo)==null){
           create(new Vehiculo(subtipo, placa, false));
           
           mensaje="{\"exitoso\":true}";    
           }
              
           
       } catch (Exception e) {
       }
    return mensaje;
    
    }
   public Vehiculo crear1(String subtipo) {
        TypedQuery<Vehiculo> qry;
        qry = getEntityManager().createQuery("SELECT v FROM Vehiculo v WHERE v.subtipo = :subtipo ", Vehiculo.class);
        
        qry.setParameter("subtipo", subtipo);
        try {
            return qry.getSingleResult();
            
        } catch (NoResultException e) {
            return null;
        }

    }
    
    
    
}
