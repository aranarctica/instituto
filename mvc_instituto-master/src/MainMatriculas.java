import java.util.ArrayList;
import java.util.Iterator;

import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Asignatura;
import modelo.AsignaturaModelo;
import modelo.Matricula;
import modelo.MatriculaModelo;
import vista.MatriculaVista;

public class MainMatriculas {

	public static void main(String[] args) {
		
		MatriculaModelo matriculaModelo = new MatriculaModelo();
		ArrayList<Matricula> matriculas = matriculaModelo.selectAll();
		
		MatriculaVista matriculaVista = new MatriculaVista();
		matriculaVista.mostrarMatriculas(matriculas);
		
		
//		MatriculaModelo matriculaModelo = new MatriculaModelo();
//		ArrayList<Matricula> matriculas = matriculaModelo.selectAll();
//		AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
//		AlumnoModelo alumnoModelo = new AlumnoModelo();
//		
//		Iterator<Matricula> i = matriculas.iterator();
//		while(i.hasNext()){
//			Matricula matricula = i.next();
//			Asignatura asignatura = asignaturaModelo.getAsignatura(matricula.getId_asignatura());
//			Alumno alumno = alumnoModelo.getAlumno(matricula.getId_alumno());
//			
//			System.out.println(alumno.getNombre() + " : " + alumno.getDni() + " : " + asignatura.getNombre() + " : "
//					+ asignatura.getHoras() + " : " + matricula.getFecha());
//			
//		}
	}

}
