package com.daniel.tienda.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.daniel.tienda.dao.IClientesDAO;
import com.daniel.tienda.dtos.ClientesDTO;
import com.daniel.tienda.entities.ClienteEntity;
import com.daniel.tienda.entities.PoblacionEntity;
import com.daniel.tienda.utils.DBUtils;

@Component("ClienteHibernateImpl")
public class ClientesDAOHibernate implements IClientesDAO {

	   @Override
	    public List<ClientesDTO> buscarClientes(String idCliente, String nombre, String correoElectronico,
	            String nombrePoblacion, String activo) throws ClassNotFoundException, SQLException, NamingException {
	        String sql = " SELECT new com.daniel.tienda.dtos.ClientesDTO(c.id, c.nombre, c.correoElectronico, p.nombre, p.id , c.activo) "
	                        + " from  ClienteEntity c, PoblacionEntity p " + "WHERE c.poblacion.id = p.id "
	                        + " AND c.nombre LIKE :nombre "
	                        + " AND c.correoElectronico LIKE :correoElectronico "
	                        + " AND c.activo = :activo";

	        if (!nombrePoblacion.equals("")) {
	            sql += (" AND c.poblacion.id = :poblacion ");
	        }

	        if (!idCliente.equals("")) {
	            sql += (" AND c.id = :id ");
	        }

	        SessionFactory factory = DBUtils.creadorSession();
	        Session s = factory.getCurrentSession();
	        s.beginTransaction();

	        Query<ClientesDTO> query = s.createQuery(sql, ClientesDTO.class)
	                .setParameter("nombre", "%" + nombre + "%")
	                .setParameter("correoElectronico", "%" + correoElectronico + "%").setParameter("activo", activo);

	        if (!nombrePoblacion.equals("")) {
	            query.setParameter("poblacion", Integer.parseInt(nombrePoblacion));
	        }

	        if (!idCliente.equals("")) {
	            query.setParameter("id", Integer.parseInt(idCliente));

	        }

	        List<ClientesDTO> listaClientes = query.getResultList();
	        s.close();
	        return listaClientes;
	    }

	    @Override
	    public Integer insertarCliente(String nombre, String correoElectronico, String nombrePoblacion, String activo)
	            throws ClassNotFoundException, SQLException, NamingException {
	        SessionFactory factory = DBUtils.creadorSession();
	        Session s = factory.getCurrentSession();
	        s.beginTransaction();

	        PoblacionEntity pe = s.find(PoblacionEntity.class, Integer.parseInt(nombrePoblacion));

	        ClienteEntity ce = new ClienteEntity(nombre, correoElectronico, pe,
	                Integer.parseInt(activo));

	        s.persist(ce);

	        s.getTransaction().commit();

	        s.close();

	        Integer idpk = ce.getId();
	        return idpk;
	    }


	@Override
	public Integer actualizarCliente(String id, String nombre, String correo, String poblacion, String activo)
			throws SQLException, ClassNotFoundException, NamingException {
		
		SessionFactory factory = DBUtils.creadorSession();
        Session s = factory.getCurrentSession();

        s.beginTransaction();
        PoblacionEntity pe = s.find(PoblacionEntity.class, Integer.parseInt(poblacion));

        ClienteEntity ce = new ClienteEntity(Integer.parseInt(id), nombre, correo,
                pe, Integer.parseInt(activo));

        s.merge(ce);
        s.getTransaction().commit();

        s.close();
        Integer idPk = ce.getId();
        return idPk;
	}

	@Override
	public Integer borrarCliente(String id) throws SQLException, ClassNotFoundException, NamingException {
		
		SessionFactory factory = DBUtils.creadorSession();
        Session s = factory.getCurrentSession();
        s.beginTransaction();

        ClienteEntity ce = s.find(ClienteEntity.class, Integer.parseInt(id));

        ce.setActivo(0);

        s.merge(ce);

        s.getTransaction().commit();

        s.close();
        return null;
	}

	
}
