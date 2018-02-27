package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProvinciaModelo extends Conector{

	public Provincia get(int id){
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from provincias where idProvincia = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Provincia provincia = new Provincia();
				provincia.setIdProvincia(rs.getInt("idProvincia"));
				provincia.setNombre(rs.getString("nombre"));
				
				return provincia;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
		
	}
	
	
}
