package model;

import observer.Observer;

public interface Cliente extends Observer {
    void setOperacao(Operacao op);      
    void executarOperacao(double valor); 
    String getNome();
}