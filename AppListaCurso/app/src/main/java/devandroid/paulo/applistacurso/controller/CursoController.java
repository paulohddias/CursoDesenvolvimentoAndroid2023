package devandroid.paulo.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.applistacurso.model.Curso;

public class CursoController {

    private List listCursos;
    public List getListaDeCursos(){
        listCursos = new ArrayList<Curso>();
        listCursos.add(new Curso("JAVA"));
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("ANDROID"));
        listCursos.add(new Curso("PHP"));
        listCursos.add(new Curso("PYTHON"));

        return listCursos;

    }


}
