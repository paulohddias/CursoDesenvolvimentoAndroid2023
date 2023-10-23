package devandroid.paulo.appgaseta.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.appgaseta.model.Curso;

public class CursoController {

    private List listCursos;

    public List getListaDeCursos() {
        listCursos = new ArrayList<Curso>();
        listCursos.add(new Curso("JAVA"));
        listCursos.add(new Curso("HTML"));
        listCursos.add(new Curso("C#"));
        listCursos.add(new Curso("ANDROID"));
        listCursos.add(new Curso("PHP"));
        listCursos.add(new Curso("PYTHON"));

        return listCursos;

    }

    public ArrayList<String> dadosParaSpinner() {
        ArrayList<String> dados = new ArrayList<>();
        for (int i = 0; i < getListaDeCursos().size(); i++) {
            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());
        }
        return dados;
    }


}
