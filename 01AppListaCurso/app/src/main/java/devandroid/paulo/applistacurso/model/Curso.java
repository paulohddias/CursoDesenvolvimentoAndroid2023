package devandroid.paulo.applistacurso.model;

public class Curso {
    private String nomeDoCursoDesejado;

    public Curso(String nomeDoCursoDesejado) {
        this.nomeDoCursoDesejado=nomeDoCursoDesejado;
    }

    public String getNomeDoCursoDesejado() {
        return nomeDoCursoDesejado;
    }

    public void setNomeDoCursoDesejado(String nomeDoCursoDesejado) {
        this.nomeDoCursoDesejado = nomeDoCursoDesejado;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nomeDoCursoDesejado='" + nomeDoCursoDesejado + '\'' +
                '}';
    }
}
