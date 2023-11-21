package devandroid.paulo.minhaideia.controller;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import devandroid.paulo.minhaideia.api.AppUtil;
import devandroid.paulo.minhaideia.datamodel.ClienteDataModel;
import devandroid.paulo.minhaideia.datasource.AppDataBase;
import devandroid.paulo.minhaideia.model.Cliente;

public class ClienteController extends AppDataBase implements ICrud<Cliente> {

    ContentValues dadoDoObjeto;


    public ClienteController(Context context) {
        super(context);

        Log.d(AppUtil.TAG, "ClienteController: Conectado");
    }

    @Override
    public boolean incluir(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        return true;
    }

    @Override
    public boolean alterar(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());

        return true;
    }

    @Override
    public boolean deletar(Cliente obj) {
        dadoDoObjeto = new ContentValues();

        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        return true;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();

        return lista;
    }
}
