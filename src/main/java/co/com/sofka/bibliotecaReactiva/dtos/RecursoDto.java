package co.com.sofka.bibliotecaReactiva.dtos;

import java.time.LocalDate;

public class RecursoDto {

    private String id;
    private String nombre;
    private boolean prestado;
    private LocalDate fechaPrestamo;
    private String tipo;
    private String tematica;

    public RecursoDto(){

    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Override
    public String toString() {
        return "RecursoDto{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", prestado=" + prestado +
                ", fechaPrestamo=" + fechaPrestamo +
                ", tipo='" + tipo + '\'' +
                ", tematica='" + tematica + '\'' +
                '}';
    }
}
