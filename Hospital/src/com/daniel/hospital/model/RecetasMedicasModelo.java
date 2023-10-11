package com.daniel.hospital.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.daniel.hospital.dtos.RecetasMedicasDTO;
import com.daniel.hospital.utils.DBUtils;

public class RecetasMedicasModelo {

	public Integer crearReceta (String pacienteNombre, String medicoNombre, String nombreMedicamento, String fecha, int cantidad)  throws ClassNotFoundException, SQLException{
		
		 String sql = "INSERT INTO RecetasMedicas (PacienteID, MedicoID, MedicamentoID, Fecha, CantidadPrescrita) " +
	                     "VALUES (" +
	                     "(SELECT id FROM Pacientes WHERE Nombre = ?)," +
	                     "(SELECT id FROM Medicos WHERE Nombre = ?)," +
	                     "(SELECT id FROM Farmacia WHERE Nombre = ?)," +
	                     "?, ?)";

	        Connection connection = DBUtils.conexionBBDD();
	        PreparedStatement ps = connection.prepareStatement(sql);
	        Integer resultado = null;

	        ps.setString(1, pacienteNombre);
	        ps.setString(2, medicoNombre);
	        ps.setString(3, nombreMedicamento);
	        ps.setString(4, fecha);
	        ps.setInt(5, cantidad);

	        resultado = ps.executeUpdate();
		connection.close();
		
		return resultado;
	
}
	 public Integer actualizaRecetaMedica(int id, String pacienteNombre, String medicoNombre, String nombreMedicamento, String fecha, int cantidad) throws ClassNotFoundException, SQLException {
		 String sql = "UPDATE RecetasMedicas SET " +
	             "PacienteID = IF(? = '', PacienteID, (SELECT id FROM Pacientes WHERE Nombre = ?)), " +
	             "MedicoID = IF(? = '', MedicoID, (SELECT id FROM Medicos WHERE Nombre = ?)), " +
	             "MedicamentoID = IF(? = '', MedicamentoID, (SELECT id FROM Farmacia WHERE Nombre = ?)), " +
	             "Fecha = IF(? = '', Fecha, ?), " +
	             "CantidadPrescrita = IF(? = '', CantidadPrescrita, ?) " +
	             "WHERE ID = ?";

	        Connection connection = DBUtils.conexionBBDD();
	        PreparedStatement ps = connection.prepareStatement(sql);
	        Integer resultado = null;

	        ps.setString(1, pacienteNombre);
	        ps.setString(2, pacienteNombre);
	        ps.setString(3, medicoNombre);
	        ps.setString(4, medicoNombre);
	        ps.setString(5, nombreMedicamento);
	        ps.setString(6, nombreMedicamento);
	        ps.setString(7, fecha);
	        ps.setString(8, fecha);
	        ps.setInt(9, cantidad);
	        ps.setInt(10, cantidad);
	        ps.setInt(11, id);
	        
	        resultado = ps.executeUpdate();
			return resultado;
	        
}
	 
	 public List <RecetasMedicasDTO> buscarReceta(int id, String pacienteNombre, String medicoNombre, String nombreMedicamento, String fecha, int cantidad) throws ClassNotFoundException, SQLException{
		 String sql = "SELECT r.ID as RecetaID, p.Nombre as PacienteNombre, m.Nombre as MedicoNombre, f.Nombre as NombreMedicamento, r.Fecha, r.CantidadPrescrita " +
                 "FROM RecetasMedicas r " +
                 "INNER JOIN Pacientes p ON r.PacienteID = p.ID " +
                 "INNER JOIN Medicos m ON r.MedicoID = m.ID " +
                 "INNER JOIN Farmacia f ON r.MedicamentoID = f.ID " +
                 "WHERE r.ID LIKE ? AND p.Nombre LIKE ? AND m.Nombre LIKE ? AND f.Nombre LIKE ? AND r.Fecha LIKE ? AND r.CantidadPrescrita LIKE ?";

    Connection connection = DBUtils.conexionBBDD();
    PreparedStatement ps = connection.prepareStatement(sql);

    // Set parameters
    ps.setString(1, "%" + id + "%");
    ps.setString(2, "%" + pacienteNombre + "%");
    ps.setString(3, "%" + medicoNombre + "%");
    ps.setString(4, "%" + nombreMedicamento + "%");
    ps.setString(5, "%" + fecha + "%");
    ps.setString(6, "%" + cantidad + "%");

    ResultSet rs = ps.executeQuery();
    List<RecetasMedicasDTO> listaRecetas = new ArrayList<>();

    while (rs.next()) {
        listaRecetas.add(new RecetasMedicasDTO(
                rs.getInt("RecetaID"),
                rs.getString("PacienteNombre"),
                rs.getString("MedicoNombre"),
                rs.getString("NombreMedicamento"),
                rs.getString("Fecha"),
                rs.getInt("CantidadPrescrita")));
    }

    return listaRecetas;
}	
}

