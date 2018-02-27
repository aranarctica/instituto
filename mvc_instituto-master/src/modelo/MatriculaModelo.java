package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MatriculaModelo extends Conector{

	public ArrayList<Matricula> selectAll() {
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();

		AlumnoModelo alumnoModelo = new AlumnoModelo();
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from matriculas");
			while (rs.next()) {
				Matricula matricula = new Matricula();
				matricula.setAlumno(alumnoModelo.getAlumno(rs.getInt("idAlumno")));
				matricula.setAsignatura(asignaturaModelo.getAsignatura(rs.getInt("idAsignatura")));
				matricula.setFecha(rs.getDate("fecha"));

				matriculas.add(matricula);
			}
			return matriculas;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return matriculas;
	}

	public ArrayList<Matricula> getMatriculasConAsignatura(Alumno alumno) {
		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		Matricula matricula;
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from matriculas where idAlumno = ?");
			pst.setInt(1, alumno.getId());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				matricula = new Matricula();
				matricula.setFecha(rs.getDate("fecha"));
				matricula.setAsignatura(asignaturaModelo.getAsignatura(rs.getInt("idAsignatura")));
				
				matriculas.add(matricula);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return matriculas;
	}

}
