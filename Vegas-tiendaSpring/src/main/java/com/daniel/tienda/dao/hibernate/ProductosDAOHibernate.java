package com.daniel.tienda.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;
import org.hibernate.Session;

import com.daniel.tienda.dao.IProductosDAO;
import com.daniel.tienda.dtos.ProductoDTO;
import com.daniel.tienda.entities.CategoriaEntity;
import com.daniel.tienda.entities.ProductoEntity;
import com.daniel.tienda.entities.ProveedoresEntity;
import com.daniel.tienda.utils.DBUtils;

@Component("ProductosHibernateImpl")
public class ProductosDAOHibernate implements IProductosDAO{

	 @Override
	    public List<ProductoDTO> buscarProducto(String id, String nombre, String descripcion, String precio,
	            String cantidadEnStock, String nombreCategoria, String nombreProveedor)
	            throws ClassNotFoundException, SQLException, NamingException {
	        String sql = ("select new com.daniel.tienda.dtos.ProductoDTO(p.id, p.nombre, p.descripcion, p.precio, p.cantidadEnStock, c.nombre, pr.nombre, c.id,  pr.id) "
	                + "from ProductoEntity p, CategoriaEntity c, ProveedoresEntity pr "
	                + "where p.categoria.id = c.id "
	                + "and p.proveedores.id = pr.id "
	                + "and p.nombre like :nombre and p.descripcion like :descripcion and p.precio >= :precio "
	                + "and p.cantidadEnStock >= :cantidadEnStock");

	        
	        if (!nombreCategoria.equals("")) {
	            sql += (" and p.categoria.id = :categoria");
	        }

	        
	        if (!nombreProveedor.equals("")) {
	            sql += (" and p.proveedores.id = :proveedores");
	        }

	        if (!id.equals("")) {
	            sql += (" and p.id = :id");
	        }
	        
	        
	        SessionFactory factory = DBUtils.creadorSession();
	        Session s = factory.getCurrentSession();
	        s.beginTransaction();
	        
	        Query<ProductoDTO> query = s.createQuery(sql.toString(), ProductoDTO.class)
	                .setParameter("nombre", "%" + nombre + "%")
	                .setParameter("descripcion", "%" + descripcion + "%").setParameter("precio", Double.parseDouble(precio))
	                .setParameter("cantidadEnStock", Integer.parseInt(
	                        cantidadEnStock));
	        
	        
	        
	        if (!nombreCategoria.equals("")) {
	            query.setParameter("categoria", nombreCategoria);
	        
	        }
	        
	        
	        if (!nombreProveedor.equals("")) {
	            query.setParameter("proveedores", Integer.parseInt(nombreProveedor));
	        }
	        
	        if (!id.equals("")) {
	            query.setParameter("id", Integer.parseInt(
	                    id));
	        
	        }
	        
	    
	        
	        


	        
	        List<ProductoDTO> listaProductos = query.getResultList();
	        s.close();
	        return listaProductos;
	    }


	 @Override
	    public Integer insertarProducto(String nombre, String descripcion, String precio, String cantidadEnStock,
	            String nombreCategoria, String nombreProveedor) throws ClassNotFoundException, SQLException, NamingException {
	        SessionFactory factory = DBUtils.creadorSession();
	        Session s = factory.getCurrentSession();
	        s.beginTransaction();

	        
	        ProveedoresEntity pe = s.find(ProveedoresEntity.class, Integer.parseInt(nombreProveedor));
	        CategoriaEntity ce = s.find(CategoriaEntity.class, Integer.parseInt(nombreCategoria));
	        

	        ProductoEntity pre = new ProductoEntity(nombre, descripcion, Double.parseDouble(precio),
	                Integer.parseInt(cantidadEnStock), ce, pe);

	        s.persist(pre);

	        s.getTransaction().commit();

	        s.close();

	        Integer idpk = pre.getId();
	        return idpk;
	        
	    }

	 @Override
	    public Integer actualizarProducto(String id, String nombre, String descripcion, String precio,
	            String cantidadEnStock, String nombreCategoria, String nombreProveedor)
	            throws ClassNotFoundException, SQLException, NamingException {
	        SessionFactory factory = DBUtils.creadorSession();
	        Session s = factory.getCurrentSession();
	            
	            s.beginTransaction();
	            ProveedoresEntity pe = s.find(ProveedoresEntity.class, Integer.parseInt(nombreProveedor));
	            CategoriaEntity ce = s.find(CategoriaEntity.class, Integer.parseInt(nombreCategoria));
	            
	            
	            ProductoEntity pre = new ProductoEntity(Integer.parseInt(id),nombre, descripcion, Double.parseDouble(precio),
	                    Integer.parseInt(cantidadEnStock), ce, pe);
	            s.merge(pre);
	            s.getTransaction().commit();
	            
	            s.close();
	            Integer idPk = pre.getId();
	            return idPk;
	    }

}
