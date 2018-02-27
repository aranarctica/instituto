package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AsignaturaModelo extends Conector{

	public Asignatura getAsignatura(int id_asignatura) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from asignaturas where id = ?");
			pst.setInt(1, id_asignatura);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				
				return asignatura;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
