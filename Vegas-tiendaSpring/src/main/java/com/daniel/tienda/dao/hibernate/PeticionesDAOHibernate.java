package com.daniel.tienda.dao.hibernate;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.hibernate.query.Query;

import com.daniel.tienda.dao.IPeticionesDAO;
import com.daniel.tienda.dtos.PeticionesDTO;
import com.daniel.tienda.entities.CategoriaEntity;
import com.daniel.tienda.entities.ClienteEntity;
import com.daniel.tienda.entities.EstadoPedidosEntity;
import com.daniel.tienda.entities.PeticionesEntity;
import com.daniel.tienda.entities.ProductoEntity;
import com.daniel.tienda.entities.ProveedoresEntity;
import com.daniel.tienda.utils.DBUtils;

@Component("PeticionesDAOHibernate")
public class PeticionesDAOHibernate implements IPeticionesDAO{

	@Override
	public List<PeticionesDTO> buscarPeticiones(String id, String id_cliente, String id_producto, String fecha,
			String cantidad, String estado) throws SQLException, ClassNotFoundException, NamingException {

		String jpql = "SELECT NEW com.daniel.tienda.dtos.PeticionesDTO(p.id, c.id, c.nombre, pr.id, pr.nombre, p.fecha, p.cantidad, ep.id, ep.nombre) "
		        + " FROM PeticionesEntity p, ClienteEntity c, ProductoEntity pr, EstadoPedidosEntity ep "
		        + " WHERE p.cliente.id = c.id AND p.producto.id = pr.id AND p.estados.id = ep.id "
		        + " AND p.fecha >= :fecha AND p.cantidad >= :cantidad ";

		
		if(!id_cliente.equals("")) {
			jpql += (" AND p.cliente.id = :cliente ");
		}
		if(!id_producto.equals("")) {
			jpql += (" AND p.producto.id = :producto ");
		}
		if(!estado.equals("")) {
			jpql += (" AND p.estados.id = :estados ");
		}
		if(!id.equals("")) {
			jpql += (" AND p.id = :id");
		}
		
		SessionFactory factory = DBUtils.creadorSession();
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        
        Query<PeticionesDTO> query = s.createQuery(jpql, PeticionesDTO.class).setParameter("cantidad", cantidad);
        
        if(!id_cliente.equals("")) {
			query.setParameter("cliente", Integer.parseInt(id_cliente));
		}
		if(!id_producto.equals("")) {
			query.setParameter("producto", Integer.parseInt(id_producto));
		}
		if(!estado.equals("")) {
			query.setParameter("estados", Integer.parseInt(estado));
		}
		if(!id.equals("")) {
			query.setParameter("id", Integer.parseInt(id));
		}
		if(!fecha.equals("")) {
			query.setParameter("fecha", fecha);
		}
		
		List<PeticionesDTO>listaPeticiones = query.getResultList();
		s.close();
		
		return listaPeticiones;
	}

	@Override
	public Integer insertarPeticion(String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException {
		
		
		SessionFactory factory = DBUtils.creadorSession();
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        
        ClienteEntity ce = s.find(ClienteEntity.class, Integer.parseInt(id_cliente));
        ProductoEntity pre = s.find(ProductoEntity.class, Integer.parseInt(id_producto));
        EstadoPedidosEntity ep = s.find(EstadoPedidosEntity.class, Integer.parseInt(estado));
        
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        
        PeticionesEntity pe = new PeticionesEntity(ce, pre, Integer.parseInt(cantidad), ep);
        
        pe.setFecha(fecha);
       
        s.persist(pe);

        s.getTransaction().commit();

        s.close();

        Integer idpk = pe.getId();
        return idpk;
	}

	@Override
	public Integer actualizarPeticion(String id, String id_cliente, String id_producto, String cantidad, String estado)
			throws SQLException, ClassNotFoundException, NamingException {

		SessionFactory factory = DBUtils.creadorSession();
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        
        ClienteEntity ce = s.find(ClienteEntity.class, Integer.parseInt(id_cliente));
        ProductoEntity pre = s.find(ProductoEntity.class, Integer.parseInt(id_producto));
        EstadoPedidosEntity ep = s.find(EstadoPedidosEntity.class, Integer.parseInt(estado));
        
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        
        PeticionesEntity pe = new PeticionesEntity(Integer.parseInt(id),ce, pre, Integer.parseInt(cantidad), ep);
        
        pe.setFecha(fecha);
        
        s.merge(pe);
        s.getTransaction().commit();
        s.close();
        
        Integer idpk = pe.getId();
        
		return idpk;
	}

	@Override
	public Integer borrarPeticion(String id) throws SQLException, ClassNotFoundException, NamingException {
		
		SessionFactory factory = DBUtils.creadorSession();
        Session s = factory.getCurrentSession();
        s.beginTransaction();
        
        PeticionesEntity pe = s.find(PeticionesEntity.class, Integer.parseInt(id));
        
        EstadoPedidosEntity ep = s.find(EstadoPedidosEntity.class, 5);
        
        pe.setEstados(ep);
        s.merge(pe);
        
        s.getTransaction().commit();
        s.close();
		return null;
	}

	
}
