
package com.mycompany.proyectopoo;
import java.io.*;
import java.util.ArrayList;

public class Asignatura {
    //Instancias de Clase
    private String nombreAsignatura;
    private ArrayList<Unidad> listaUnidades;
    private ArrayList<String> listaRutAlumnos;
    
    //Constructor
    public Asignatura(String nombreAsignatura,String nombreUnidad, ArrayList<String> listaRutAlumnos) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaUnidades = new ArrayList<>();
        Unidad uni= new Unidad (nombreUnidad,listaRutAlumnos);
        this.listaUnidades.add(uni);
        
        this.listaRutAlumnos = new ArrayList<>();
        this.listaRutAlumnos.addAll(listaRutAlumnos);
    }
    public Asignatura(String nombreAsignatura, ArrayList<String> listaRutAlumnos) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaUnidades = new ArrayList<>();
        
        this.listaRutAlumnos = new ArrayList<>();
        this.listaRutAlumnos.addAll(listaRutAlumnos);
    }
    public Asignatura(String nombreAsignatura,String[] temasUnidades,ArrayList<String> listaRutAlumnos) {
        this.nombreAsignatura = nombreAsignatura;
        this.listaRutAlumnos = new ArrayList<>();
        this.listaRutAlumnos.addAll(listaRutAlumnos);
        this.listaUnidades = new ArrayList<>();
        for (int i = 0 ; i < temasUnidades.length ; i++)
        {
            Unidad uni = new Unidad(temasUnidades[i],listaRutAlumnos);
            this.listaUnidades.add(uni);
        }
    }
    
    
    
    //Metodos
    //Metodos de llenado
    
    
    public void addPreguntaUnidad(String nombreUnidad, String pregunta)
    {
        for(int i = 0; i < this.listaUnidades.size(); i++ )
        {
            if((this.listaUnidades.get(i).getNombreUnidad()).toLowerCase().equals(nombreUnidad.toLowerCase()))
            this.listaUnidades.get(i).addPregunta(pregunta);
        }
    }
    
    public void addAlumnoAsig(String rutAlumno)
    {
        this.listaRutAlumnos.add(rutAlumno);
        for(int i = 0 ; i < this.listaUnidades.size() ; i++ )
            this.listaUnidades.get(i).addAlumnoUnidad(rutAlumno);
    }
    public void addUnidad(String nombreUnidad)
    {
        Unidad uni = new Unidad (nombreUnidad,this.listaRutAlumnos);
        this.listaUnidades.add(uni);
    }
    
    public ArrayList <String> getNombreUnidades()
    {
        ArrayList <String> listaNombresUnidades= new ArrayList <String>();
        for (int i = 0 ; i < this.listaUnidades.size() ; i++)
            listaNombresUnidades.add(this.listaUnidades.get(i).getNombreUnidad());
        return listaNombresUnidades;
    }
    
    public ArrayList<String> getListaPreguntasUnidad(String nombreUnidad) 
    {
        ArrayList <String> listaPreguntas= new ArrayList <String>();
        for(int k = 0; k < this.listaUnidades.size(); k++ )
        {
            if((this.listaUnidades.get(k).getNombreUnidad()).toLowerCase().equals(nombreUnidad.toLowerCase()))
            listaPreguntas = this.listaUnidades.get(k).getPreguntas();
        }
        return listaPreguntas;
    }
    public  ArrayList<Double> getListaNotasUnidad(String nombreUnidad) 
    {
        ArrayList<Double> notas = new ArrayList<>();
        for(int k = 0; k < this.listaUnidades.size(); k++ )
        {
            if((this.listaUnidades.get(k).getNombreUnidad()).toLowerCase().equals(nombreUnidad.toLowerCase()))
            notas = this.listaUnidades.get(k).getNotas();
        }
        return notas;
    }
    
    //Getters y Setters
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    


}