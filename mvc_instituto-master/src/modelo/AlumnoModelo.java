package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoModelo extends Conector {

	public Alumno getAlumno(int id_alumno) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from alumnos where id = ?");
			pst.setInt(1, id_alumno);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setEmail(rs.getString("email"));

				return alumno;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Alumno> selectAllConMatriculas() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		MatriculaModelo matriculaModelo = new MatriculaModelo();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos");
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setEmail(rs.getString("email"));
				ArrayList<Matricula> matriculas = matriculaModelo.getMatriculasConAsignatura(alumno);
				alumno.setMatriculas(matriculas);

				alumnos.add(alumno);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}

	public ArrayList<Alumno> selectAll() {
		Statement st;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		try {
			st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos, provincias");
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setEmail(rs.getString("email"));
				Provincia provincia = new Provincia();
				provincia.setIdProvincia(rs.getInt("idProvincia"));
				provincia.setNombre(rs.getString("nombre"));
				alumno.setProvincia(provincia);

				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	
//	prubea ller fitxero y insertar en base de datos
//	
//	
//	
//	public void leerFichero() throws IOException, SQLException{
//		try {
//			FileReader fr = new FileReader("D:Ebal2/Programacion/alumnos.txt");
//			BufferedReader entradaArchivo=new BufferedReader(fr);
//			String linea=entradaArchivo.readLine();
//			while (linea != null) {
//				String[] palabras = linea.split(" ");
//				String part1 = palabras[0];
//				String part2 = palabras[1];
//				String part3 = palabras[2];
//				String part4 = palabras[3];
//				PreparedStatement pst = super.conexion.prepareStatement("insert into alumnos");
//				
//				pst.setString(1, part2);
//				pst.setString(2, part4);
//				pst.setString(3, part1);
//				pst.setString(4, part3);
//				pst.executeUpdate();
//			}
//			
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		
//	}

}
