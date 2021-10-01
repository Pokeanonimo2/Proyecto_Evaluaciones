package com.mycompany.proyectopoo;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Unidad {
    
    //Instancias de Clase
    private String nombreUnidad;
    private ArrayList<String> preguntasUnidad;
    private String fechaEvaluacion;
    private ArrayList<Double> listaNotas;
    private ArrayList<String> listaRutAlumnos;
    BufferedReader lector = new BufferedReader(new InputStreamReader (System.in));
   
    //Constructor
    public Unidad(String nombreUnidad,ArrayList<String> listaRutAlumnos) {
        this.nombreUnidad = nombreUnidad;
        this.preguntasUnidad = new ArrayList<>();
        this.listaRutAlumnos = new ArrayList<>();
        this.listaRutAlumnos.addAll(listaRutAlumnos);
        Calendar c = Calendar.getInstance();
        this.fechaEvaluacion = Integer.toString(c.get(Calendar.DATE))+"/"+Integer.toString(c.get(Calendar.MONTH))+"/"+ Integer.toString(c.get(Calendar.YEAR));
        
        double posibleNota;
        this.listaNotas = new ArrayList<>();
        for(int i = 0 ; i < this.listaRutAlumnos.size() ; i++)
        {
            //se llenan las notas del alumno (i) con una nota random y se guardan en la lista de notas en 
            //la misma posicion del alumno
            do
            {
                
                
                // notas de prueba, luego se llenaran correctamente
                posibleNota= (int)(Math.random() * 6 + 1);
            }while((posibleNota > 7) || (posibleNota <1) );
            this.listaNotas.add(posibleNota);
        }
    }
    
    //Metodos
    //Metodos de llenado
    
    public void addPregunta(String pregunta)
    {
        this.preguntasUnidad.add(pregunta);
    }
    
    public void addAlumnoUnidad(String rutAlumno)
    {
        
        this.listaRutAlumnos.add(rutAlumno);
    }
    
    public ArrayList<String> getPreguntas()
    {
        ArrayList<String> listaPreguntas = new  ArrayList<>();
        for(int i = 0 ; i< this.preguntasUnidad.size(); i++)
            listaPreguntas.add(this.preguntasUnidad.get(i));
        return listaPreguntas;
    }
    public ArrayList<Double> getNotas()
    {
        ArrayList<Double> notas = new ArrayList<>();
        for(int i = 0 ; i< this.listaNotas.size(); i++)
            notas.add(this.listaNotas.get(i));
        return notas;
    }
    public boolean deleteAlumno(String rutAlumno)
    {
        if (this.listaRutAlumnos.remove(rutAlumno))
        {
            return true;
        }
        return false;
    }
    public boolean replaceAlumno(String rutOriginal, String rutNuevo)
    {
        if (this.listaRutAlumnos.contains(rutOriginal))
        {
            int  i = this.listaRutAlumnos.indexOf(rutOriginal);
            this.listaRutAlumnos.remove(rutOriginal);
            this.listaRutAlumnos.add(i,rutNuevo);
            return true;
        }
        return false;
    }
    
    //Getters y Setters
    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public String getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(String fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}