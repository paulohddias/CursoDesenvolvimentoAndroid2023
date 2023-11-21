package devandroid.paulo.minhaideia.controller;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.minhaideia.datamodel.ProdutoDataModel;
import devandroid.paulo.minhaideia.datasource.AppDataBase;
import devandroid.paulo.minhaideia.model.Produto;

public class ProdutoController extends AppDataBase implements ICrud<Produto> {

    ContentValues dadoDoObjeto;

    public ProdutoController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return true;
    }

    @Override
    public boolean alterar(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.ID, obj.getId());
        dadoDoObjeto.put(ProdutoDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ProdutoDataModel.FORNECEDOR, obj.getFornecedor());

        return true;
    }

    @Override
    public boolean deletar(Produto obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ProdutoDataModel.ID, obj.getId());

        return true;
    }

    @Override
    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();

        return lista;
    }
}
