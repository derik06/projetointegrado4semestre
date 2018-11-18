package service;

import dao.LedDAO;
import model.Led;

public class LedService {

    public LedService(){};

    LedDAO dao = new LedDAO();

    public void ligarLed(Led led) {dao.ligarLed(led);}

    public void desligarLed(Led led) {dao.desligarLed(led);}

}


//public class ClienteService {
//    ClienteDAO dao = new ClienteDAO();
//
//    public int criar(Cliente cliente) {
//        return dao.criar(cliente);
//    }
//
//    public void atualizar(Cliente cliente){
//        dao.atualizar(cliente);
//    }
//
//    public void excluir(int id){
//        dao.excluir(id);
//    }
//
//    public Cliente carregar(int id){
//        return dao.carregar(id);
//    }
//
//}