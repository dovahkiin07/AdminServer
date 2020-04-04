/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import com.mycompany.as1soapservice.jpa.ShowsJpaController;
import com.mycompany.as1soapservice.models.Shows;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author adityatuli
 */
@WebService(serviceName = "ShowCrud")
@MTOM(enabled=true,threshold=1000000)
@HandlerChain(file = "/ShowCrud_handler.xml")
public class ShowCrud {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "add")
    public Shows add(@WebParam(name = "show") Shows shows) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            ShowsJpaController showRepo = new ShowsJpaController(emf);
            if(shows.getId()==null){
                List<Shows> showList = showRepo.findShowsEntities();
                List<BigDecimal> ids = new ArrayList<BigDecimal>();
                for (Shows s : showList) {
                    ids.add(s.getId());
                }
                shows.setId(Collections.max(ids).add(BigDecimal.ONE));
                showRepo.create(shows);
            }
            else{
                showRepo.edit(shows);
            }
            return shows;
        } catch (Exception ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    
    @WebMethod(operationName = "getAll")
    public List<Shows> getAll() {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            ShowsJpaController showRepo = new ShowsJpaController(emf);
            List<Shows> shows= showRepo.findShowsEntities();
            return shows;
        } catch (Exception ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }  
    }
    
    @WebMethod(operationName = "findById")
    public Shows findById(@WebParam(name = "show") BigDecimal id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            ShowsJpaController showRepo = new ShowsJpaController(emf);
            return showRepo.findShows(id);
        } catch (Exception ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } 
    }
    
    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "show") BigDecimal id) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB");
            ShowsJpaController showRepo = new ShowsJpaController(emf);
            showRepo.destroy(id);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ShowCrud.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
