package modelo;

import java.util.Date;

public class Matricula {

	private Date fecha;

	// por la relacion
	private Asignatura asignatura; // id_asignatura;
	private Alumno alumno; // id_alumno;

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	// public int getId_asignatura() {
	// return id_asignatura;
	// }
	// public void setId_asignatura(int id_asignatura) {
	// this.id_asignatura = id_asignatura;
	// }
	// public int getId_alumno() {
	// return id_alumno;
	// }
	// public void setId_alumno(int id_alumno) {
	// this.id_alumno = id_alumno;
	// }
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
